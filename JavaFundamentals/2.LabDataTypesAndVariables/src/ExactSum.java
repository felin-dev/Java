import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());

        BigDecimal sum = new BigDecimal(0);
        for (int i = 0; i < count; i++) {
            BigDecimal next = new BigDecimal(sc.nextLine());

            sum = sum.add(next);
        }

        System.out.println(sum);
    }
}
