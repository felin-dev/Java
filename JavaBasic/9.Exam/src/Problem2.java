import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double movieBudged = Double.parseDouble(sc.nextLine());
        int staticsQuantity = Integer.parseInt(sc.nextLine());
        double pricePerStatics = Double.parseDouble(sc.nextLine());

        double decorPrice = movieBudged * 0.10;
        if (staticsQuantity > 150) {
            pricePerStatics *= 0.90;
        }

        double expensesPrice = staticsQuantity * pricePerStatics + decorPrice;

        if (movieBudged >= expensesPrice) {
            double moneyLeft = movieBudged - expensesPrice;
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.",moneyLeft);
        } else {
            double moneyNeeded = expensesPrice - movieBudged;
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", moneyNeeded);
        }
    }
}
