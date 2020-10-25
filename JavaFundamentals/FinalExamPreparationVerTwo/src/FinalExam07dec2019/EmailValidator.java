package FinalExam07dec2019;

import java.util.Scanner;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String email = sc.nextLine();
        String input = sc.nextLine();
        while (!"Complete".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Make":
                    if (tokens[1].equals("Upper")) {
                        email = email.toUpperCase();
                    } else {
                        email = email.toLowerCase();
                    }

                    System.out.println(email);
                    break;
                case "GetDomain":
                    int domain = Integer.parseInt(tokens[1]);
                    int printFrom = email.length() - domain;
                    System.out.println(String.format("%s", email.substring(printFrom)));
                    break;
                case "GetUsername":
                    if (email.contains("@")) {
                        int endOfUser = email.indexOf('@');
                        String username = email.substring(0, endOfUser);
                        System.out.println(String.format("%s", username));
                    } else {
                        System.out.println(String.format("The email %s doesn't contain the @ symbol.", email));
                    }
                    break;
                case "Replace":
                    char charToReplace = tokens[1].charAt(0);
                    email = email.replace(charToReplace, '-');
                    System.out.println(email);
                    break;
                case "Encrypt":
                    for (int i = 0; i < email.length() - 1; i++) {
                        char currentChar = email.charAt(i);
                        System.out.print((int) currentChar + " ");
                    }

                    System.out.println((int) email.charAt(email.length() - 1));
                    break;
            }

            input = sc.nextLine();
        }
    }
}