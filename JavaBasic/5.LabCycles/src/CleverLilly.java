import java.util.Scanner;

public class CleverLilly {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int yearsOld = Integer.parseInt(sc.nextLine());
        double washingMachinePrice = Double.parseDouble(sc.nextLine());
        int pricePerToy = Integer.parseInt(sc.nextLine());

        double lillysMoney = 0.0;
        int moneyForBirthday = 10;
        int toyCount = 0;
        for (int i = 1; i <= yearsOld; i++) {
            if (i % 2 == 0) {
                lillysMoney = lillysMoney + moneyForBirthday - 1;
                moneyForBirthday = moneyForBirthday + 10;
            } else {
                toyCount++;
            }
        }
        double moneyFromToys = toyCount * pricePerToy;
        lillysMoney = lillysMoney + moneyFromToys;
        if (lillysMoney >= washingMachinePrice) {
            double moneyLeft = lillysMoney - washingMachinePrice;
            System.out.printf("Yes! %.2f", moneyLeft);
        } else {
            double moneyNeeded = washingMachinePrice - lillysMoney;
            System.out.printf("No! %.2f", moneyNeeded);
        }
    }
}
