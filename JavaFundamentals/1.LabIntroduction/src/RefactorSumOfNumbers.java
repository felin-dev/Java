import java.util.Scanner;

public class RefactorSumOfNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int refactorNumber = Integer.parseInt(sc.nextLine());
        int sum = 0;
        int counter = 0;
        int currentNumber = 1;
        while (counter < refactorNumber) {
            if (currentNumber % 2 != 0) {
                System.out.printf("%n%d", currentNumber);
                sum += currentNumber;
                counter++;
            }
            currentNumber++;
        }

        System.out.printf("%nSum: %d", sum);
    }
}
