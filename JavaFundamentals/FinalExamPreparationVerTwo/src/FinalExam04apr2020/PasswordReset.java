package FinalExam04apr2020;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String password = sc.nextLine();

        String input = sc.nextLine();
        while (!"Done".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "TakeOdd":
                    password = takeOdd(password);
                    printPassword(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    password = cut(password, index, length);
                    printPassword(password);
                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];
                    if (password.contains(substring)) {
                        password = password.replace(substring, substitute);
                        printPassword(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            input = sc.nextLine();
        }

        System.out.println(String.format("Your password is: %s", password));
    }

    private static String cut(String password, int index, int length) {
        StringBuilder passwordBuilder = new StringBuilder();
        int endIndex = index + length - 1;
        for (int i = 0; i < password.length(); i++) {
            if (i < index || i > endIndex) {
                passwordBuilder.append(password.charAt(i));
            }
        }
        password = passwordBuilder.toString();

        return password;
    }

    private static String takeOdd(String password) {
        StringBuilder passwordBuilder = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            if (i % 2 == 1) {
                passwordBuilder.append(password.charAt(i));
            }
        }
        password = passwordBuilder.toString();

        return password;
    }

    private static void printPassword(String password) {
        System.out.println(password);
    }
}