import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());
        int sum = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            number /= 10;
            sum += lastDigit;
        }

        System.out.println(sum);
    }
}
