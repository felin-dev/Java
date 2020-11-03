import java.util.Scanner;

public class Orders {
    private  static final double WATER = 1.0;
    private  static final double COKE = 1.4;
    private  static final double COFFEE = 1.5;
    private  static final double SNACKS = 2.0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String order = sc.nextLine();
        int quantity = Integer.parseInt(sc.nextLine());

        double total = receipt(order, quantity);
        System.out.printf("%.2f", total);
    }

    private static double receipt(String order, int quantity) {
        return productPrice(order) * quantity;
    }

    private static double productPrice(String order) {
        double orderPrice = 0;
        switch (order) {
            case "water": return WATER;
            case "coke": return COKE;
            case "coffee": return COFFEE;
            case "snacks": return SNACKS;
            default:
                System.out.println("Error!");
        }

        return orderPrice;
    }
}
