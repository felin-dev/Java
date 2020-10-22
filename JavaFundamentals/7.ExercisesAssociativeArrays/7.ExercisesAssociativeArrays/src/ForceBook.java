import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> users = new LinkedHashMap<>();
        String input = sc.nextLine();
        while (!"Lumpawaroo".equals(input)) {
            if (input.contains("|")) {
                String[] tokens = input.split("\\s+\\|\\s+");
                String user = tokens[1];
                String side = tokens[0];
                users.putIfAbsent(user, side);
            }

            if (input.contains("->")) {
                String[] tokens = input.split("\\s+->\\s+");
                String user = tokens[0];
                String side = tokens[1];
                if (users.containsKey(user) && !users.get(user).equals(side)) {
                    joinUser(users, user, side);
                } else if (!users.containsKey(user)) {
                    joinUser(users, user, side);
                }
            }

            input = sc.nextLine();
        }

        Map<String, List<String>> sidesCount = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : users.entrySet()) {
            sidesCount.putIfAbsent(entry.getValue(), new ArrayList<>());
            sidesCount.get(entry.getValue()).add(entry.getKey());
        }

        sidesCount
                .entrySet()
                .stream()
                .sorted((u1, u2) ->{
                    int u1Size = u1.getValue().size();
                    int u2Size = u2.getValue().size();
                    if (u1Size == u2Size) {
                        return u1.getKey().compareTo(u2.getKey());
                    }
                    return u1Size - u2Size;
                })
                .forEach(entry -> {
                    System.out.println(String.format("Side: %s, Members: %d", entry.getKey(), entry.getValue().size()));
                    entry
                            .getValue()
                            .stream()
                            .sorted(String::compareTo)
                            .forEach(s -> System.out.println(String.format("! %s", s)));
                });
    }

    private static void joinUser(Map<String, String> users, String user, String side) {
        users.put(user, side);
        System.out.printf("%s joins the %s side!%n", user, side);
    }
}