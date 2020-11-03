import java.util.Scanner;

public class MultiplyEvenByOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String number = sc.nextLine();
        int result = multiplication(number);
        System.out.println(result);
    }

    private static int multiplication(String number) {
        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != 45) {
                int currentNumber = number.charAt(i);
                currentNumber -= 48;
                if (number.charAt(i) % 2 == 0) {
                    evenSum += currentNumber;
                } else {
                    oddSum += currentNumber;
                }
            }
        }
        return evenSum * oddSum;
    }
}
