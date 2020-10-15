import java.util.Scanner;

public class Savings {
    public static double expenses = 0.7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double monthlyIncome = Double.parseDouble(sc.nextLine());
        int months = Integer.parseInt(sc.nextLine());
        double moneyNeededPerMonth = Double.parseDouble(sc.nextLine());

        double budged = monthlyIncome * expenses;
        double moneySavedPerMonth = budged - moneyNeededPerMonth;
        double percentSavedMoney = moneySavedPerMonth / monthlyIncome * 100;

        double totalSavedMoney = moneySavedPerMonth * months;

        System.out.printf("She can save %.2f%%%n", percentSavedMoney);
        System.out.printf("%.2f", totalSavedMoney);
    }
}
