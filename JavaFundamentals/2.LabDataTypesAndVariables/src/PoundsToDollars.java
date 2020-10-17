import java.util.Scanner;

public class PoundsToDollars {
    private static final double POUNDS_TO_DOLLARS_EXCHANGE_RATE = 1.31;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double dollars = Double.parseDouble(sc.nextLine());
        double pounds = dollars * POUNDS_TO_DOLLARS_EXCHANGE_RATE;
        System.out.printf("%.3f", pounds);
    }
}
