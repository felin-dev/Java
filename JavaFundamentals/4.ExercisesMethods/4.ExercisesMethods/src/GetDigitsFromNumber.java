import java.util.Arrays;
import java.util.Scanner;

public class GetDigitsFromNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String numberString = sc.nextLine();

        for (int i = 0; i < numberString.length(); i++) {
            char currentChar = numberString.charAt(i);
            int currentDigit = currentChar - '0';
            System.out.println("Current char: " + (int)currentChar);
            System.out.println("Current digit: " + currentDigit);
        }

        int number = Integer.parseInt(numberString);
        int digit = 0;
        int length = 0;

        int numberForDigits = number;
        while (numberForDigits > 0) {
            digit = (numberForDigits % 10);
            numberForDigits = numberForDigits / 10;
            System.out.print(digit + " ");
            length ++;
        }

        System.out.println();
        System.out.println(length);

        int[] numberArray = new int[length];
        int counter = length;
        while (number > 0) {
            digit = (number % 10);
            number = number / 10;
            for (int i = 0; i < length; i++) {
                numberArray[counter - 1] = digit;
            }
            counter--;
        }

        System.out.println(Arrays.toString(numberArray));

        String[] stringArray = {"Yolo", "John", "Piece"};
        System.out.println(String.join("+++", stringArray));
    }
}

