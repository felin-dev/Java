import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double number = Double.parseDouble(sc.nextLine());
        int power = Integer.parseInt(sc.nextLine());

        double result = powering(number, power);
        System.out.println(new DecimalFormat("0.####").format(result));
    }

    private static double powering(double number, int power) {
        return Math.pow(number, power);
    }
}
