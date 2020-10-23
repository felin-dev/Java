import java.util.Scanner;

public class DigitsLettersAndOthers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder other = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (Character.isAlphabetic(current)) {
                letters.append(current);
            } else if (Character.isDigit(current)) {
                digits.append(current);
            } else {
                other.append(current);
            }
        }

        System.out.println(digits);
        System.out.println(letters);
        System.out.println(other);
    }
}