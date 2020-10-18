import java.util.Scanner;

public class PrintMiddleCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        printMiddle(input);
    }

    private static void printMiddle(String input) {
        if (input.length() % 2 == 0) {
            int firstChar = input.length() / 2 - 1;
            int secondChar = input.length() / 2;
            System.out.print(input.charAt(firstChar) + "" + input.charAt(secondChar));
        } else {
            int middleCharacter = input.length() / 2;
            System.out.println(input.charAt(middleCharacter));
        }
    }
}
