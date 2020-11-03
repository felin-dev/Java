import java.util.Scanner;

public class TopNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int range = Integer.parseInt(sc.nextLine());
        topNumbers(range);
    }

    private static void topNumbers(int range) {
        for (int i = 0; i < range; i++) {
            boolean sumDivisibleByEight = sumDivisibleByEight(i);
            boolean hasOddDigit = hasOddDigit(i);
            if (sumDivisibleByEight && hasOddDigit) {
                System.out.println(i);
            }
        }
    }

    private static boolean hasOddDigit(int number) {
        boolean hasOddDigit = false;
        int currentDigit;

        while (number > 0) {
            currentDigit = (number % 10);
            number = number / 10;
            if (currentDigit % 2 != 0) {
                hasOddDigit = true;
            }
        }

        return hasOddDigit;
    }

    private static boolean sumDivisibleByEight(int currentNumber) {
        boolean divisible = false;
        int currentDigit;
        int sum = 0;
        while (currentNumber > 0) {
            currentDigit = (currentNumber % 10);
            currentNumber = currentNumber / 10;
            sum += currentDigit;
        }

        if (sum % 8 == 0) {
            divisible = true;
        }

        return divisible;
    }
}
