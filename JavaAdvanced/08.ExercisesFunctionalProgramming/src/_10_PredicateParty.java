import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _10_PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> invitedPeople = Arrays.stream(reader.readLine().split("\\s+"))
                .map(String::toString)
                .collect(Collectors.toList());

        String input = reader.readLine();
        while (!input.equals("Party!")) {
            String[] tasks = input.split("\\s+");
            String command = tasks[0];
            switch (command) {
                case "Double": {
                    String criteria = tasks[1];
                    String symbols = tasks[2];
                    duplicate(criteria, invitedPeople, symbols);
                    break;
                }
                case "Remove": {
                    String criteria = tasks[1];
                    String symbols = tasks[2];
                    remove(criteria, invitedPeople, symbols);
                    break;
                }
            }

            input = reader.readLine();
        }

        if (invitedPeople.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(invitedPeople
                    .stream()
                    .sorted()
                    .collect(Collectors.joining(", ")) + " are going to the party!");
        }
    }

    private static void duplicate(String criteria, List<String> invitedPeople, String symbols) {
        for (int i = 0; i < invitedPeople.size(); i++) {
            String invitedPerson = invitedPeople.get(i);
            if (getPredicate(criteria, symbols).test(invitedPerson)) {
                invitedPeople.add(i++, invitedPerson);
            }
        }

    }

    private static void remove(String criteria, List<String> invitedPeople, String symbols) {
        invitedPeople.removeIf(getPredicate(criteria, symbols));
    }

    private static Predicate<String> getPredicate(String criteria, String symbols) {
        switch (criteria) {
            case "StartsWith":
                return person -> person.startsWith(symbols);
            case "EndsWith":
                return person -> person.endsWith(symbols);
            case "Length":
                return person -> person.length() == Integer.parseInt(symbols);
            default:
                return person -> false;
        }
    }
}
