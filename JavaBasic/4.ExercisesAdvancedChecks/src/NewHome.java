import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;

public class NewHome {

    private static final double ROSE_PRICE = 5.00;
    private static final double DAHLIA_PRICE = 3.80;
    private static final double TULIP_PRICE = 2.80;
    private static final double NARCISSUS_PRICE = 3.00;
    private static final double GLADIOLUS_PRICE = 2.50;

    private static final int ROSE_DISCOUNT_THRESHOLD = 80;
    private static final int DAHLIA_DISCOUNT_THRESHOLD = 90;
    private static final int TULIP_DISCOUNT_THRESHOLD = 80;
    private static final int NARCISSUS_PENALTY_THRESHOLD = 120;
    private static final int GLADIOLUS_PENALTY_THRESHOLD = 80;

    private static final double ROSE_DISCOUNT_COEFFICIENT = 0.9;
    private static final double DAHLIA_DISCOUNT_COEFFICIENT = 0.85;
    private static final double TULIP_DISCOUNT_COEFFICIENT = 0.85;
    private static final double NARCISSUS_PENALTY_COEFFICIENT = 1.15;
    private static final double GLADIOLUS_PENALTY_COEFFICIENT = 1.20;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String flowerType = sc.nextLine();
        int flowerCount = parseInt(sc.nextLine());
        int budged = parseInt(sc.nextLine());

        double totalPrice = getTotalPrice(flowerType, flowerCount);

        if (budged >= totalPrice) {
            double moneyLeft = budged - totalPrice;
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowerCount, flowerType, moneyLeft);
        } else {
            double moneyNeeded = totalPrice - budged;
            System.out.printf("Not enough money, you need %.2f leva more.", moneyNeeded);
        }
    }

    private static double getTotalPrice(String flowerType, int flowerCount) {
        switch (flowerType) {
            case "Roses":
                return getTotalPrice(flowerCount, ROSE_PRICE, ROSE_DISCOUNT_COEFFICIENT, flowerCount > ROSE_DISCOUNT_THRESHOLD);
            case "Dahlias":
                return getTotalPrice(flowerCount, DAHLIA_PRICE, DAHLIA_DISCOUNT_COEFFICIENT, flowerCount > DAHLIA_DISCOUNT_THRESHOLD);
            case "Tulips":
                return getTotalPrice(flowerCount, TULIP_PRICE, TULIP_DISCOUNT_COEFFICIENT, flowerCount > TULIP_DISCOUNT_THRESHOLD);
            case "Narcissus":
                return getTotalPrice(flowerCount, NARCISSUS_PRICE, NARCISSUS_PENALTY_COEFFICIENT, flowerCount < NARCISSUS_PENALTY_THRESHOLD);
            case "Gladiolus":
                return getTotalPrice(flowerCount, GLADIOLUS_PRICE, GLADIOLUS_PENALTY_COEFFICIENT, flowerCount < GLADIOLUS_PENALTY_THRESHOLD);
            default:
                throw new IllegalArgumentException(format("Problem! :%s", flowerType));
        }
    }

    private static double getTotalPrice(int flowerCount, double flowerPrice, double coefficient, boolean applyCoefficient) {
        if (!applyCoefficient) {
            return flowerCount * flowerPrice;
        }

        return flowerCount * flowerPrice * coefficient;
    }
}
