import java.util.Scanner;

public class BakingCompetition {
    public static final double cookiesPrice = 1.50;
    public static final double cakesPrice = 7.80;
    public static final double wafflesPrice = 2.30;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cooks = Integer.parseInt(sc.nextLine());

        String baking = "";
        int totalBakedGoods = 0;
        String cookName = "";
        double totalCharitySum = 0;
        for (int i = 1; i <= cooks; i++) {
            int totalCookies = 0;
            int totalCakes = 0;
            int totalWaffles = 0;
            cookName = sc.nextLine();
            baking = "";
            while (!baking.equals("Stop baking!")) {
                baking = sc.nextLine();
                if (!baking.equals("Stop baking!")){
                    int currentBakedGoods = Integer.parseInt(sc.nextLine());
                    totalBakedGoods += currentBakedGoods;
                    switch (baking) {
                        case "cookies": {
                            totalCookies += currentBakedGoods;
                            break;
                        }
                        case "cakes": {
                            totalCakes += currentBakedGoods;
                            break;
                        }
                        case "waffles": {
                            totalWaffles += currentBakedGoods;
                            break;
                        }
                        default:
                            System.out.println("Error!");
                    }
                }
            }

            System.out.printf("%s baked %d cookies, %d cakes and %d waffles.%n", cookName, totalCookies, totalCakes, totalWaffles);
            totalCharitySum = totalCharitySum + totalCookies * cookiesPrice + totalCakes * cakesPrice + totalWaffles * wafflesPrice;
        }

        System.out.printf("All bakery sold: %d%n", totalBakedGoods);
        System.out.printf("Total sum for charity: %.2f lv.", totalCharitySum);
    }
}
