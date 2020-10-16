import java.util.Scanner;

public class VendingMachine {
    private static final double NUTS_PRICE = 2.0;
    private static final double WATER_PRICE = 0.7;
    private static final double CRISPS_PRICE = 1.5;
    private static final double SODA_PRICE = 0.8;
    private static final double COKE_PRICE = 1.0;
    private static final int UNKNOWN_PRODUCT_PRICE = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double totalMoney = 0;
        while (true) {
            String line = sc.nextLine();
            if (line.equals("Start")) {
                break;
            }

            double currentPrice = Double.parseDouble(line);
            if (currentPrice == 2 || currentPrice == 1 || currentPrice == 0.5 || currentPrice == 0.2 || currentPrice == 0.1) {
                totalMoney += currentPrice;
            } else {
                System.out.printf("Cannot accept %.2f%n", currentPrice);
            }
        }

        while (true) {
            String line = sc.nextLine();
            if (line.equals("End")) {
                break;
            }

            double currentProductPrice = getProductPrice(line);
            if (currentProductPrice == UNKNOWN_PRODUCT_PRICE) {
                System.out.println("Invalid product");
            } else if (totalMoney >= currentProductPrice) {
                System.out.printf("Purchased %s%n", line);
                totalMoney -= currentProductPrice;
            } else {
                System.out.println("Sorry, not enough money");
            }
        }

        System.out.printf("Change: %.2f%n", totalMoney);
    }

    private static double getProductPrice(String productName) {
        switch (productName) {
            case ("Nuts"):
                return NUTS_PRICE;
            case ("Water"):
                return WATER_PRICE;
            case ("Crisps"):
                return CRISPS_PRICE;
            case ("Soda"):
                return SODA_PRICE;
            case ("Coke"):
                return COKE_PRICE;
            default:
            return UNKNOWN_PRODUCT_PRICE;
        }
    }
}
