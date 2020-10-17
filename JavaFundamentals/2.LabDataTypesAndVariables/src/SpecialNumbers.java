import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= count; i++) {
            int digitSum = 0;

            int currentNumber = i;
            while (currentNumber > 0) {
                digitSum += currentNumber % 10;
                currentNumber = currentNumber / 10;
            }

            boolean isSpecial = (digitSum == 5) || (digitSum == 7) || (digitSum == 11);
            if (isSpecial) {
                System.out.println(i + " -> True");
            } else {
                System.out.println(i + " -> False");
            }
        }
    }
}
