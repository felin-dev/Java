import java.util.Scanner;

public class Movie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double budget = Double.parseDouble(sc.nextLine());
        int statists = Integer.parseInt(sc.nextLine());
        double clothesPerStatists = Double.parseDouble(sc.nextLine());

        double decor = budget * 0.1;
        double totalClothesPrice = statists * clothesPerStatists;

        if (statists > 150) {
            totalClothesPrice = totalClothesPrice * 0.9;
        }

        double totalPrice = decor + totalClothesPrice;

        if (totalPrice > budget) {
            System.out.println("Not enough money!");
            double diff = totalPrice - budget;
            System.out.printf("Wingard needs %.2f leva more.", diff);
        } else {
            System.out.println("Action!");
            double diff = budget - totalPrice;
            System.out.printf("Wingard starts filming with %.2f leva left.", diff);
        }
    }
}
