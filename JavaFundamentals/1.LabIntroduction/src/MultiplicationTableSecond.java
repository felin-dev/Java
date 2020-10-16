import java.util.Scanner;

public class MultiplicationTableSecond {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int firstMultiplyingNumber = Integer.parseInt(sc.nextLine());
        int secondMultiplyingNumber = Integer.parseInt(sc.nextLine());
        if ((firstMultiplyingNumber <= 10) && (secondMultiplyingNumber <= 10)) {
            for (int i = secondMultiplyingNumber; i <= 10; i++) {
                int multiplication = firstMultiplyingNumber * secondMultiplyingNumber;
                printingWholeMultiplication(firstMultiplyingNumber, secondMultiplyingNumber, multiplication);
                secondMultiplyingNumber++;
            }

            } else {
                int multiplication = firstMultiplyingNumber * secondMultiplyingNumber;
            printingWholeMultiplication(firstMultiplyingNumber, secondMultiplyingNumber, multiplication);
        }
    }

    private static void printingWholeMultiplication(int firstMultiplyingNumber, int secondMultiplyingNumber, int multiplication) {
        System.out.printf("%n%d X %d = %d", firstMultiplyingNumber, secondMultiplyingNumber, multiplication);
    }
}
