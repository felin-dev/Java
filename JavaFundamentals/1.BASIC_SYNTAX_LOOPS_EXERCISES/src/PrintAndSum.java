import java.util.Scanner;

public class PrintAndSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstNumber = Integer.parseInt(sc.nextLine());
        int lastNumber = Integer.parseInt(sc.nextLine());
        int sum = 0;

        for (int i = firstNumber; i <= lastNumber; i++) {
            System.out.print(i + " ");
            sum+=i;
        }

        System.out.printf("%nSum: %d", sum);
    }
}
