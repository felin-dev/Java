package FinalRetake10apr2020;

import java.util.Scanner;

public class SecretChat_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String message = sc.nextLine();
        String input = sc.nextLine();
        while (!"Reveal".equals(input)) {
            String[] commands = input.split(":\\|:");
            String command = commands[0];
            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(commands[1]);
                    message = insertSpace(message, index);
                    System.out.println(message);
                    break;
                case "Reverse":
                    String reverse = commands[1];
                    if (message.contains(reverse)) {
                        message = message.replaceFirst(reverse, "");
                        message = message + reversed(reverse);
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String substring = commands[1];
                    String replacement = commands[2];
                    message = message.replace(substring, replacement);
                    System.out.println(message);
                    break;
            }

            input = sc.nextLine();
        }

        System.out.println("You have a new text message: " + message);
    }

    private static String reversed(String reverse) {
        StringBuilder messageBuilder = new StringBuilder();
        for (int i = reverse.length() - 1; i >= 0; i--) {
            messageBuilder.append(reverse.charAt(i));
        }

        return messageBuilder.toString();
    }

    private static String insertSpace(String message, int index) {
        StringBuilder messageBuilder = new StringBuilder();
        if (index > 0) {
            messageBuilder.append(message, 0, index);
        }
        messageBuilder.append(" ");
        messageBuilder.append(message.substring(index));

        return messageBuilder.toString();
    }
}