import java.util.Scanner;

public class RefactorSumOfNumbersVerTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int refactorNumber = Integer.parseInt(sc.nextLine());
        int sum = 0;
        for (int i = 1; i <= refactorNumber * 2; i++) {

            if (i % 2 != 0) {
                System.out.printf("%n%d", i);
                sum += i;
            }
        }

        System.out.printf("%nSum: %d", sum);
    }
}
