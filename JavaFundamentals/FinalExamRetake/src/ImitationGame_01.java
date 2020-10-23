import java.util.Scanner;

public class ImitationGame_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String encryptedMessage = sc.nextLine();
        String input = sc.nextLine();
        while (!"Decode".equals(input)) {
            String[] tasks = input.split("\\|+");
            String command = tasks[0];
            switch (command) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(tasks[1]);
                    if (numberOfLetters < encryptedMessage.length()) {
                        encryptedMessage = move(encryptedMessage, numberOfLetters);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tasks[1]);
                    String value = tasks[2];
                    if (index >= 0 && index <= encryptedMessage.length()) {
                        encryptedMessage = insert(encryptedMessage, index, value);
                    }
                    break;
                case "ChangeAll":
                    String substring = tasks[1];
                    String replacement = tasks[2];
                    if (encryptedMessage.contains(substring)) {
                        encryptedMessage = encryptedMessage.replace(substring, replacement);
                    }
                    break;
            }

            input = sc.nextLine();
        }

        System.out.println("The decrypted message is: " + encryptedMessage);
    }

    private static String insert(String encryptedMessage, int index, String value) {
        StringBuilder sb = new StringBuilder();
        if (index > 0) {
            sb.append(encryptedMessage, 0, index);
        }

        sb.append(value);

        if (index < encryptedMessage.length()) {
            sb.append(encryptedMessage, index, encryptedMessage.length());
        }

        return sb.toString();
    }

    private static String move(String encryptedMessage, int numberOfLetters) {
        StringBuilder sb = new StringBuilder(encryptedMessage);
        String lettersToMove = encryptedMessage.substring(0, numberOfLetters);
        sb.replace(0, numberOfLetters, "");
        sb.append(lettersToMove);

        return sb.toString();
    }
}