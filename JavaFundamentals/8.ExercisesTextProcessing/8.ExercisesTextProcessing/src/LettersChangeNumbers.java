import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split("\\s+");
        double finalSum = 0.0;

        for (String word : words) {
            char firstLetter = word.charAt(0);
            char lastLetter = word.charAt(word.length() - 1);
            String numbersAsString = word.substring(1, word.length() - 1);
            long number = Integer.parseInt(numbersAsString);

            double result;

            if (Character.isUpperCase(firstLetter)) {
                result = number * 1.0 / (firstLetter - ('A' - 1));
            } else {
                result = number * (firstLetter - ('a' - 1));
            }

            if (Character.isUpperCase(lastLetter)) {
                result -= lastLetter - ('A' - 1);
            } else {
                result += lastLetter - ('a' - 1);
            }

            finalSum += result;
        }

        System.out.println(String.format("%.2f", finalSum));
    }
}