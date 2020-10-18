import java.util.Scanner;

public class SignOfInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());

        sign(number);
    }

    private static void sign(int num) {
        String sign = "zero";
        if (num > 0) {
            sign = "positive";
        } else if (num < 0) {
            sign = "negative";
        }

        System.out.printf("The number %d is %s.", num, sign);
    }
}
