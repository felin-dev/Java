import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _5_PhoneBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> contactsInfo = new TreeMap<>();
        String input = sc.nextLine();
        while (!input.equals("search")) {
            String[] contactInfo = input.split("-");
            String contact = contactInfo[0];
            String number = contactInfo[1];
            contactsInfo.put(contact, number);

            input = sc.nextLine();
        }

        StringBuilder output = new StringBuilder();
        input = sc.nextLine();
        while (!input.equals("stop")) {
            String wantedContact = input;
            if (contactsInfo.containsKey(wantedContact)) {
                output.append(String.format("%s -> %s%n", wantedContact, contactsInfo.get(wantedContact)));
            } else {
                output.append(String.format("Contact %s does not exist.%n", wantedContact));
            }

            input = sc.nextLine();
        }

        System.out.println(output);
    }
}