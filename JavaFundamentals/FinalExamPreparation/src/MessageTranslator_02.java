import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputs = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < inputs; i++) {
            String input = sc.nextLine();
            printValidInput(input);
        }
    }

    private static void printValidInput(String input) {
        String regex = "!(?<command>[A-Z][a-z][a-z]+)!:\\[(?<toEncrypt>[A-Za-z]{7}[A-Za-z]+)]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            encryption(matcher.group("command"), matcher.group("toEncrypt"));
        } else {
            System.out.println("The message is invalid");
        }
    }

    private static void encryption(String command, String toEncrypt) {
        System.out.print(command + ": ");
        for (int i = 0; i < toEncrypt.length() - 1; i++) {
            int currentChar = toEncrypt.charAt(i);
            System.out.print(String.format("%d ", currentChar));
        }
        int lastChar = toEncrypt.charAt(toEncrypt.length() - 1);
        System.out.println(String.format("%d", lastChar));
    }
}