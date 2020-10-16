import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String number = sc.nextLine();
        int sum = 0;
        for(char digit: number.toCharArray()) {
            sum += getFactorial(digit - '0');
        }

        if (sum == Integer.parseInt(number)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private static int getFactorial(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }

        return result;
    }
}

