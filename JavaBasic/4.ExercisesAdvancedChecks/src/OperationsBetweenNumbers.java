import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n1 = Integer.parseInt(sc.nextLine());
        double n2 = Integer.parseInt(sc.nextLine());
        String symbol = sc.nextLine();

        double result;
        if (symbol.equals("+")) {
            result = n1 + n2;
            System.out.printf("%.0f + %.0f = %.0f", n1, n2, result);
            evenOrOdd(result);
        }
        if (symbol.equals("-")) {
            result = n1 - n2;
            System.out.printf("%.0f - %.0f = %.0f", n1, n2, result);
            evenOrOdd(result);
        }
        if (symbol.equals("*")) {
            result = n1 * n2;
            System.out.printf("%.0f * %.0f = %.0f", n1, n2, result);
            evenOrOdd(result);
        }
        if (symbol.equals("/")) {
            if (n1 == 0 || n2 == 0) {
                System.out.printf("Cannot divide %.0f by zero", n1);
            } else {
                result = n1 / n2;
                System.out.printf("%.0f / %.0f = %.2f", n1, n2, result);
            }
        }
        if (symbol.equals("%")) {
            if (n1 == 0 || n2 == 0) {
                System.out.printf("Cannot divide %.0f by zero", n1);
            } else {
                result = n1 % n2;
                System.out.printf("%.0f ", n1);
                System.out.print("% ");
                System.out.printf("%.0f = %.0f", n2, result);
            }
        }

    }

    private static void evenOrOdd(double result) {
        if ((result) % 2 == 0) {
            System.out.println(" - even");
        } else {
            System.out.println(" - odd");
        }
    }
}
