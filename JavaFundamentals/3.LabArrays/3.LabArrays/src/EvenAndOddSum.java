import java.util.Scanner;

public class EvenAndOddSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] numbers = line.split(" ");

        int evenSum = 0;
        int oddSum = 0;
        for (String number : numbers) {
            int currentNumber = Integer.parseInt(number);
            if (currentNumber % 2 == 0) {
                evenSum += currentNumber;
            } else {
                oddSum += currentNumber;
            }
        }

        int difference = evenSum - oddSum;
        System.out.println(difference);
    }
}
