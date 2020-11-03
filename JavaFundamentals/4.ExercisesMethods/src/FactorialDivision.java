import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int first = Integer.parseInt(sc.nextLine());
        int second = Integer.parseInt(sc.nextLine());

        factorialDivision(first, second);
    }

    private static void factorialDivision(int first, int second) {
        long firstFactorial = factorial(first);
        long secondFactorial = factorial(second);
        double division = firstFactorial * 1.0 / secondFactorial;
        System.out.printf("%.2f", division);
    }

    private static long factorial(int number) {
        long factorial = 1L;
        for (int i = 1; i <= number; i++) {
            factorial = factorial * i;
        }

        return factorial;
    }
}
