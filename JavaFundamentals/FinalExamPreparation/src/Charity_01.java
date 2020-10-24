import java.util.Scanner;

public class Charity_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String encryptedInput = sc.nextLine();
        StringBuilder encrypted = new StringBuilder();
        encrypted.append(encryptedInput);
        String command = sc.nextLine();

        while (!"Finish".equals(command)) {
            String[] commandParts = command.split("\\s+");
            String commandName = commandParts[0];
            switch (commandName) {
                case "Replace":
                    replace(encrypted, commandParts[1].charAt(0), commandParts[2].charAt(0));
                    break;
                case "Cut": {
                    int beginIndex = Integer.parseInt(commandParts[1]);
                    int endIndex = Integer.parseInt(commandParts[2]);
                    cut(encrypted, beginIndex, endIndex);
                    break;
                }
                case "Make":
                    String make = commandParts[1];
                    returnMake(encrypted, make);
                    break;
                case "Check":
                    String checkFor = commandParts[1];
                    if (encrypted.toString().contains(checkFor)) {
                        System.out.println(String.format("Message contains %s", checkFor));
                    } else {
                        System.out.println(String.format("Message doesn't contain %s", checkFor));
                    }
                    break;
                case "Sum": {
                    int beginIndex = Integer.parseInt(commandParts[1]);
                    int endIndex = Integer.parseInt(commandParts[2]);
                    sum(encrypted, beginIndex, endIndex);
                    break;
                }
            }

            command = sc.nextLine();
        }
    }

    private static void sum(StringBuilder encrypted, int beginIndex, int endIndex) {
        boolean valid = isValidIndex(encrypted, beginIndex, endIndex);
        int sum = 0;
        if (valid) {
            for (int i = beginIndex; i <= endIndex; i++) {
                char currentChar = encrypted.charAt(i);
                sum += currentChar;
            }

            System.out.println(sum);
        }
    }

    private static void returnMake(StringBuilder encrypted, String make) {
        if ("Upper".equals(make)) {
            encrypted.setLength(0);
            encrypted.append(encrypted.toString().toUpperCase());
            System.out.println(encrypted);
        } else if ("Lower".equals(make)) {
            encrypted.setLength(0);
            encrypted.append(encrypted.toString().toLowerCase());
            System.out.println(encrypted);
        }
    }

    private static void cut(StringBuilder decrypted, int beginIndex, int endIndex) {
        boolean valid = isValidIndex(decrypted, beginIndex, endIndex);
        if (valid) {
            decrypted.replace(beginIndex, endIndex + 1, "");
            System.out.println(decrypted);
        }
    }

    private static boolean isValidIndex(StringBuilder decrypted, int beginIndex, int endIndex) {
        if (beginIndex >= 0 && beginIndex < decrypted.length() && endIndex >= 0 &&
                endIndex < decrypted.length() && beginIndex <= endIndex) {
            return true;
        } else {
            System.out.println("Invalid indexes!");
            return false;
        }

    }

    private static void replace(StringBuilder decrypted, char searchFor, char replaceWith) {
        String newString = decrypted.toString().replace(searchFor, replaceWith);
        decrypted.setLength(0);
        decrypted.append(newString);
        System.out.println(decrypted);
    }
}
