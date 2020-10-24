import java.util.*;

public class Meals_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<String>> likedMeals = new LinkedHashMap<>();
        int unlikedMeals = 0;
        String input = sc.nextLine();
        while (!"Stop".equals(input)) {
            String[] commandParts = input.split("-");
            String command = commandParts[0];
            String name = commandParts[1];
            String meal = commandParts[2];
            switch (command) {
                case "Like":
                    likedMeals.putIfAbsent(name, new ArrayList<>());
                    List<String> guestMeals = likedMeals.get(name);
                    if (!guestMeals.contains(meal)) {
                        guestMeals.add(meal);
                    }
                    break;
                case "Unlike":
                    if (likedMeals.containsKey(name)) {
                        if (likedMeals.get(name).contains(meal)) {
                            likedMeals.get(name).remove(meal);
                            System.out.println(String.format("%s doesn't like the %s.", name, meal));
                            unlikedMeals++;
                        } else {
                            System.out.println(String.format("%s doesn't have the %s in his/her collection.", name, meal));
                        }
                    } else if (!likedMeals.containsKey(name)) {
                        System.out.println(String.format("%s is not at the party.", name));
                    }
                    break;

            }

            input = sc.nextLine();
        }

        likedMeals
                .entrySet()
                .stream()
                .sorted((c1, c2) -> {
                    int res = Integer.compare(c2.getValue().size(), c1.getValue().size());
                    if (res == 0) {
                        res = c1.getKey().compareTo(c2.getKey());
                        return res;
                    } else {
                        return res;
                    }
                })
                .forEach(entry -> System.out.println(String.format("%s: %s", entry.getKey(), entry.getValue().toString().replaceAll("[\\[\\]]", ""))));
        System.out.println(String.format("Unliked meals: %d", unlikedMeals));
    }
}