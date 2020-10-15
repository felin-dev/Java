import java.util.Scanner;

public class SummerShopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int budged = Integer.parseInt(sc.nextLine());
        double beachTowelPrice = Double.parseDouble(sc.nextLine());
        int discount = Integer.parseInt(sc.nextLine());

        double umbrellaPrice = beachTowelPrice * 2 / 3;
        double flipFlopsPrice = umbrellaPrice * 0.75;
        double beachBagPrice = (flipFlopsPrice + beachTowelPrice) / 3;

        double totalPrice = beachTowelPrice + umbrellaPrice + flipFlopsPrice + beachBagPrice;
        double discountPercent = discount * 1.0 / 100;
        double finalPrice = totalPrice - totalPrice * discountPercent;

        if (budged >= finalPrice) {
            double moneyLeft = budged - finalPrice;
            System.out.printf("Annie's sum is %.2f lv. She has %.2f lv. left.", finalPrice, moneyLeft);
        } else {
            double moneyNeeded = finalPrice - budged;
            System.out.printf("Annie's sum is %.2f lv. She needs %.2f lv. more.", finalPrice, moneyNeeded);
        }
    }
}
