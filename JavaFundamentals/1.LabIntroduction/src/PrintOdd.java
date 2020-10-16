import java.util.Scanner;

public class PrintOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int oddCount = Integer.parseInt(sc.nextLine());

        int counter = 0;
        int oddSum = 0;
        int currentNumber = 1;
        while (counter < oddCount) {
            if (currentNumber % 2 != 0) {
                System.out.println(currentNumber);
                oddSum += currentNumber;
                counter++;
            }
            currentNumber++;
        }

        System.out.printf("Sum: %d", oddSum);
    }
}
