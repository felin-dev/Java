import java.util.Scanner;

public class NumberOnPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int p = 2;
        for (int i = 0; i <= n; i += p) {
            System.out.printf("%.0f%n", Math.pow(p, i));
        }
    }
}
