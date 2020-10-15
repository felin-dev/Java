import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int key = Integer.parseInt(sc.nextLine());

        boolean yes = false;
        for (int a = 1; a <= 30; a++) {
            for (int b = 1; b <= 30; b++) {
                for (int c = 1; c <= 30; c++) {
                    if (a < b && b < c) {
                        int sum = a + b + c;
                        if (sum == key) {
                            System.out.printf("%d + %d + %d = %d%n", a, b, c, key);
                            yes = true;
                        }
                    }
                    if (a > b && b > c) {
                        int sum2 = a * b * c;
                        if (sum2 == key) {
                            System.out.printf("%d * %d * %d = %d%n", a, b, c, key);
                            yes = true;
                        }
                    }
                }
            }
        }

        if (!yes) {
            System.out.println("No!");
        }
    }
}
