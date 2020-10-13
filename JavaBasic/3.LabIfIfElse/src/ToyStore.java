import java.util.Scanner;

public class ToyStore {

    private static final double PUZZLE_PRICE = 2.60;
    private static final double DOLL_PRICE = 3;
    private static final double TEDDY_BEAR_PRICE = 4.10;
    private static final double MINION_PRICE = 8.20;
    private static final double TRUCK_PRICE = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double excursionPrice = Double.parseDouble(sc.nextLine());
        int puzzleCount = Integer.parseInt(sc.nextLine());
        int dollCount = Integer.parseInt(sc.nextLine());
        int teddyBearCount = Integer.parseInt(sc.nextLine());
        int minionCount = Integer.parseInt(sc.nextLine());
        int truckCount = Integer.parseInt(sc.nextLine());

        double puzzleTotalPrice = puzzleCount * PUZZLE_PRICE;
        double dollTotalPrice = dollCount * DOLL_PRICE;
        double teddyBearTotalPrice = teddyBearCount * TEDDY_BEAR_PRICE;
        double minionTotalPrice = minionCount * MINION_PRICE;
        double truckTotalPrice = truckCount * TRUCK_PRICE;

        double totalPrice = puzzleTotalPrice + dollTotalPrice + teddyBearTotalPrice +
                minionTotalPrice + truckTotalPrice;
        int totalCount = puzzleCount + dollCount + teddyBearCount + minionCount + truckCount;

        double discount = 0;
        if (totalCount >= 50) {
            discount = totalPrice * 0.25;
        }

        double finalPrice = (totalPrice - discount) * 0.9;
        if (finalPrice >= excursionPrice) {
            double moneyAfterExcursion = finalPrice - excursionPrice;
            System.out.printf("Yes! %.2f lv left.", moneyAfterExcursion);
        } else {
            double moneyNeededForExcursion = excursionPrice - finalPrice;
            System.out.printf("Not enough money! %.2f lv needed.", moneyNeededForExcursion);
        }
    }

}
