import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String factorial = sc.nextLine();
        int factorialNumber = Integer.parseInt(factorial);
        System.out.println(fact(factorialNumber));
    }

    public static int fact (int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }
}
