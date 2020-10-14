import java.util.Scanner;

public class EqualSumsOddPosition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = Integer.parseInt(sc.nextLine());
        int end = Integer.parseInt(sc.nextLine());

        for (int i = start; i <= end; i++) {

            int evenSum = 0;
            int oddSum = 0;
            int number = i;
            int isEven = 1;
            while (number  > 0) {
                int digit = number % 10;
                if (isEven % 2 == 0) {
                    evenSum += digit;
                } else {
                    oddSum += digit;
                }
                isEven++;
                number /= 10;
            }

            if (evenSum == oddSum) {
                System.out.print(i + " ");
            }
        }
    }
}
