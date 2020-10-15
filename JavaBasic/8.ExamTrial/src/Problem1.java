import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double foodMoney = Double.parseDouble(sc.nextLine());
        double souvenirMoney = Double.parseDouble(sc.nextLine());
        double hotelMoney = Double.parseDouble(sc.nextLine());

        double fuelMoney = 420 / 100.0 * 7 * 1.85;
        double moneyForFoodAndSouvenirs = 3.0 * foodMoney + 3.0 * souvenirMoney;
        double dayOne = hotelMoney * 0.9;
        double dayTwo = hotelMoney * 0.85;
        double dayTree = hotelMoney * 0.8;
        double totalHotelMoney = dayOne + dayTwo + dayTree;
        double totalMoneyNeeded = totalHotelMoney + moneyForFoodAndSouvenirs + fuelMoney;
        System.out.printf("Money needed: %.2f", totalMoneyNeeded);
    }
}
