import java.util.Scanner;

public class MultiplyTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String multiplicationNumber = sc.nextLine();

        char c1 = multiplicationNumber.charAt(2);
        char c2 = multiplicationNumber.charAt(1);
        char c3 = multiplicationNumber.charAt(0);

        int n1 = Character.getNumericValue(c1);
        int n2 = Character.getNumericValue(c2);
        int n3 = Character.getNumericValue(c3);
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                for (int k = 1; k <= n3; k++) {
                    int result = i * j * k;
                    System.out.printf("%d * %d * %d = %d;%n", i, j, k, result);
                }
            }
        }
    }
}
