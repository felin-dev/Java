package ManOWar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] shipInfo = sc.nextLine().split(">");
        List<Integer> pirateShip = new ArrayList<>();
        getShipInfo(shipInfo, pirateShip);
        shipInfo = sc.nextLine().split(">");
        List<Integer> warShip = new ArrayList<>();
        getShipInfo(shipInfo, warShip);

        int maximumHealth = Integer.parseInt(sc.nextLine());

        String input = sc.nextLine();
        while (!"Retire".equals(input)) {
            String[] commands = input.split("\\s+");
            String command = commands[0];
            switch (command) {
                case "Fire": {
                    //•	Fire {index} {damage} – the pirate ship attacks the warship with the given damage at that section.
                    // Check if the index is valid and if not skip the command. If the section breaks (health <= 0)
                    // the warship sinks, print the following and stop the program:
                    //"You won! The enemy ship has sunken."
                    int attackingIndex = Integer.parseInt(commands[1]);
                    int damage = Integer.parseInt(commands[2]);
                    if (warShip.size() - 1 < attackingIndex || attackingIndex < 0) {
                        break;
                    }
                    if (warShip.get(attackingIndex) <= damage) {
                        System.out.println("You won! The enemy ship has sunken.");
                        return;
                    } else {
                        int healthLeft = warShip.get(attackingIndex) - damage;
                        warShip.set(attackingIndex, healthLeft);
                    }
                    break;
                }
                case "Defend": {
                    //•	Defend {startIndex} {endIndex} {damage} - the warship attacks the pirate ship with the given
                    // damage at that range (indexes are inclusive). Check if both indexes are valid and if not skip
                    // the command. If the section breaks (health <= 0) the pirate ship sinks, print the following and stop the program:
                    //"You lost! The pirate ship has sunken."

                    int startingIndex = Integer.parseInt(commands[1]);
                    int endIndex = Integer.parseInt(commands[2]);
                    int damage = Integer.parseInt(commands[3]);
                    if (startingIndex < 0 || startingIndex > pirateShip.size() - 1
                            || endIndex > pirateShip.size() - 1 || endIndex < 0) {
                        break;
                    }

                    for (int i = startingIndex; i <= endIndex; i++) {
                        if (pirateShip.get(i) <= damage) {
                            System.out.println("You lost! The pirate ship has sunken.");
                            return;
                        } else {
                            int healthAfterDamage = pirateShip.get(i) - damage;
                            pirateShip.set(i, healthAfterDamage);
                        }
                    }
                    break;
                }
                case "Repair":{
                    int indexToRepair = Integer.parseInt(commands[1]);
                    int healthPoints = Integer.parseInt(commands[2]);
                    if (pirateShip.size() - 1 < indexToRepair || indexToRepair < 0) {
                        break;
                    }

                    int partHealthAfterRepair = pirateShip.get(indexToRepair) + healthPoints;
                    if (partHealthAfterRepair > maximumHealth) {
                        partHealthAfterRepair = maximumHealth;
                    }
                    pirateShip.set(indexToRepair, partHealthAfterRepair);
                    //•	Repair {index} {health} - the crew repairs a section of the pirate ship with the given health.
                    // Check if the index is valid and if not skip the command. The health of the section cannot exceed
                    // the maximum health capacity.
                    break;
                }
                case "Status":{
                    double lowHealth = maximumHealth * 0.2;
                    int pirateLowHealthCounter = 0;
                    for (Integer currentPart : pirateShip) {
                        if (currentPart < lowHealth) {
                            pirateLowHealthCounter++;
                        }
                    }

                    System.out.println(pirateLowHealthCounter + " sections need repair.");
                    //•	Status – prints the count of all sections of the pirate ship that need repair soon, which are
                    // all sections that are lower than 20% of the maximum health capacity. Print the following:
                    //"{count} sections need repair."
                    break;
                }
            }

            input = sc.nextLine();
        }

        //In the end if a stalemate occurs print the status of both ships, which is the sum of their
        // individual sections in the following format:
        //"Pirate ship status: {pirateShipSum}"
        //"Warship status: {warshipSum}"
        int pirateShipHealthLeft = 0;
        for (Integer health : pirateShip) {
            pirateShipHealthLeft += health;
        }
        System.out.printf("Pirate ship status: %d%n", pirateShipHealthLeft);

        int warShipHealthLeft = 0;
        for (Integer health : warShip) {
            warShipHealthLeft += health;
        }
        System.out.printf("Warship status: %d", warShipHealthLeft);
    }

    private static void getShipInfo(String[] shipInfo, List<Integer> shipInfoSplit) {
        for (String shipPart : shipInfo) {
            shipInfoSplit.add(Integer.parseInt(shipPart));
        }
    }
}
