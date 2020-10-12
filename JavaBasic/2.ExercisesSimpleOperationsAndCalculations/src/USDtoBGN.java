import java.util.Scanner;

public class USDtoBGN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double usd = Double.parseDouble(sc.nextLine());
        double rate = 1.79549;
        double bgn = usd * rate;
        System.out.printf("%.2f", bgn);
    }
}
