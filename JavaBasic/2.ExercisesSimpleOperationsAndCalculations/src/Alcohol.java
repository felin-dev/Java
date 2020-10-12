import java.util.Scanner;

public class Alcohol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double whiskeyPrice = Double.parseDouble(sc.nextLine());
        double beerQuantity = Double.parseDouble(sc.nextLine());
        double wineQuantity = Double.parseDouble(sc.nextLine());
        double rakiaQuantity = Double.parseDouble(sc.nextLine());
        double whiskeyQuantity = Double.parseDouble(sc.nextLine());

        double rakiaPrice = whiskeyPrice * 0.5;
        double winePrice = rakiaPrice * 0.6;
        double beerPrice = rakiaPrice * 0.2;

        double totalPrice = (whiskeyPrice * whiskeyQuantity) +
                (beerPrice * beerQuantity) + (winePrice * wineQuantity) +
                (rakiaPrice * rakiaQuantity);
        System.out.printf("%.2f", totalPrice);
    }
}
