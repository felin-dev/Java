import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double budged = Double.parseDouble(sc.nextLine());
        String season = sc.nextLine();

        if (budged <= 100) {
            System.out.println("Somewhere in Bulgaria");
            if (season.equals("summer")){
                double moneyLeft = budged * 0.3;
                System.out.printf("Camp - %.2f", moneyLeft);
            } else {
                double moneyLeft = budged * 0.7;
                System.out.printf("Hotel - %.2f", moneyLeft);
            }
        }
        if (budged <= 1000 && budged > 100) {
            System.out.println("Somewhere in Balkans");
            if (season.equals("summer")){
                double moneyLeft = budged * 0.4;
                System.out.printf("Camp - %.2f", moneyLeft);
            } else {
                double moneyLeft = budged * 0.8;
                System.out.printf("Hotel - %.2f", moneyLeft);
            }
        }
        if (budged > 1000) {
            double moneyLeft = budged * 0.9;
            System.out.println("Somewhere in Europe");
            System.out.printf("Hotel - %.2f", moneyLeft);
        }
    }
}
