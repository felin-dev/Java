import java.util.Scanner;

public class SumDivisionMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int firstNumber = Integer.parseInt(sc.nextLine());
        int secondNumber = Integer.parseInt(sc.nextLine());
        int divideNumber = Integer.parseInt(sc.nextLine());
        int multiplyingNumber = Integer.parseInt(sc.nextLine());

        int sum = firstNumber + secondNumber;
        int division = sum / divideNumber;
        int multiplication = division * multiplyingNumber;

        System.out.println(multiplication);
    }
}
