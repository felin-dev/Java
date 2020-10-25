package FinalExam07dec2019;

import java.util.*;

public class InboxManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<String>> usersEmails = new LinkedHashMap<>();
        String input = sc.nextLine();
        while (!"Statistics".equals(input)) {
            String[] tokens = input.split("->");
            String command = tokens[0];
            String username = tokens[1];
            switch (command) {
                case "Add":
                    if (!usersEmails.containsKey(username)) {
                        usersEmails.put(username, new ArrayList<>());
                    } else {
                        System.out.println(String.format("%s is already registered", username));
                    }
                    break;
                case "Send":
                    String email = tokens[2];
                    usersEmails.get(username).add(email);
                    break;
                case "Delete":
                    if (usersEmails.containsKey(username)) {
                        usersEmails.remove(username);
                    } else {
                        System.out.println(String.format("%s not found!", username));
                    }
                    break;
            }

            input = sc.nextLine();
        }
        System.out.println(String.format("Users count: %d", usersEmails.size()));

        usersEmails
                .entrySet()
                .stream()
                .sorted((a, b) -> {
                    int result = Integer.compare(b.getValue().size(), a.getValue().size());
                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }

                    return result;
                })
                .forEach(entry -> {
                    System.out.println(String.format("%s", entry.getKey()));
                    entry.getValue().forEach(value -> System.out.println(String.format(" - %s", value)));
                });
    }
}
