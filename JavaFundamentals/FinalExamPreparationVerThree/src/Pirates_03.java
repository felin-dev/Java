import java.util.*;

public class Pirates_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<Integer>> targetedTowns = new TreeMap<>();
        String input = sc.nextLine();
        while (!"Sail".equals(input)) {
            String[] townInfo = input.split("\\|\\|");
            String town = townInfo[0];
            int townPopulation = Integer.parseInt(townInfo[1]);
            int townGoldReserve = Integer.parseInt(townInfo[2]);

            if (!targetedTowns.containsKey(town)) {
                targetedTowns.put(town, new ArrayList<>());
                targetedTowns.get(town).add(0, townPopulation);
                targetedTowns.get(town).add(1, townGoldReserve);
            } else {
                int oldPopulation = targetedTowns.get(town).get(0);
                int oldGoldReserve = targetedTowns.get(town).get(1);
                targetedTowns.put(town, new ArrayList<>());
                targetedTowns.get(town).add(0, townPopulation + oldPopulation);
                targetedTowns.get(town).add(1, townGoldReserve + oldGoldReserve);
            }

            //Until the "Sail" command is given you will be receiving:
            //•	Cities that you and your crew have targeted, with their population and gold, separated by "||".
            //•	If you receive a city which has been already received, you have to increase the population and
            // gold with the given values.
            //After the "Sail" command, you will start receiving lines of text representing events until the
            // "End" command is given.

            input = sc.nextLine();
        }

        input = sc.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("=>");
            String command = tokens[0];
            switch (command) {
                case "Plunder":{
                    String town = tokens[1];
                    int populationKilled = Integer.parseInt(tokens[2]);
                    int stolenGold = Integer.parseInt(tokens[3]);
                    if (targetedTowns.containsKey(town)) {
                        int populationAfterTheKilling = targetedTowns.get(town).get(0) - populationKilled;
                        int goldAfterStealing = targetedTowns.get(town).get(1) - stolenGold;
                        if (populationAfterTheKilling < 0) {
                            populationAfterTheKilling = 0;
                        }

                        if (goldAfterStealing < 0) {
                            goldAfterStealing = 0;
                        }

                        populationKilled = targetedTowns.get(town).get(0) - populationAfterTheKilling;
                        stolenGold = targetedTowns.get(town).get(1) - goldAfterStealing;
                        targetedTowns.get(town).set(0, populationAfterTheKilling);
                        targetedTowns.get(town).set(1, goldAfterStealing);

                        System.out.println(String.format("%s plundered! %d gold stolen, %d citizens killed.",
                                town, stolenGold, populationKilled));

                        if (populationAfterTheKilling <= 0 || goldAfterStealing <= 0) {
                            System.out.println(String.format("%s has been wiped off the map!", town));
                            targetedTowns.remove(town);
                        }
                    }
                    //Events will be in the following format:
                    //•	"Plunder=>{town}=>{people}=>{gold}"
                    //o	You have successfully attacked and plundered the town, killing the given number of people and
                    // stealing the respective amount of gold.
                    //o	For every town you attack print this message:
                    // "{town} plundered! {gold} gold stolen, {people} citizens killed."
                    //o	If any of those two values (population or gold) reaches zero, the town is disbanded.
                    //	You need to remove it from your collection of targeted cities and print the following message:
                    // "{town} has been wiped off the map!"
                    //o	There will be no case of receiving more people or gold than there is in the city.
                    break;}
                case "Prosper":{
                    String town = tokens[1];
                    if (targetedTowns.containsKey(town)) {
                        int goldAdded = Integer.parseInt(tokens[2]);
                        if (goldAdded < 0) {
                            System.out.println("Gold added cannot be a negative number!");
                            break;
                        }

                        targetedTowns.get(town).set(1, targetedTowns.get(town).get(1) + goldAdded);
                        System.out.println(String.format("%d gold added to the city treasury. %s now has %d gold.",
                                goldAdded, town, targetedTowns.get(town).get(1)));
                        //•	"Prosper=>{town}=>{gold}"
                        //o	There has been a dramatic economic growth in the given city, increasing its treasury by the
                        // given amount of gold.
                        //o	The gold amount can be a negative number, so be careful. If a negative amount of gold is given print:
                        // "Gold added cannot be a negative number!" and ignore the command.
                        //o	If the given gold is a valid amount, increase the town's gold reserves by the
                        // respective amount and print
                        // the following message: "{gold added} gold added to the city treasury. {town} now has {total gold} gold."
                    }

                    break;}
                default:
                    throw new RuntimeException();
            }

            input = sc.nextLine();
        }

        if (targetedTowns.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.println(String.format("Ahoy, Captain! There are %d wealthy settlements to go to:", targetedTowns.size()));
            targetedTowns
                    .entrySet()
                    .stream()
                    .sorted((town1, town2) -> Integer.compare(town2.getValue().get(1), town1.getValue().get(1)))
                    .forEach(town -> System.out.println(String.format("%s -> Population: %d citizens, Gold: %d kg",
                            town.getKey(), town.getValue().get(0), town.getValue().get(1))));
        }
        //•	After receiving the "End" command if there are any existing settlements on your list of targets,
        // you need to print all of them, sorted by their gold in descending order, then by their
        // name in ascending order, in the following format:
        //Ahoy, Captain! There are {count} wealthy settlements to go to:
        //{town1} -> Population: {people} citizens, Gold: {gold} kg
        //   …
        //{town…n} -> Population: {people} citizens, Gold: {gold} kg
        //•	If there are no settlements left to plunder, print:
        //"Ahoy, Captain! All targets have been plundered and destroyed!"
    }
}