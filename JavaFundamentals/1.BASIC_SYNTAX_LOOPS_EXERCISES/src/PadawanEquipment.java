import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double startingMoney = Double.parseDouble(sc.nextLine());
        int numberOfStudents = Integer.parseInt(sc.nextLine());
        double lightsaberPrice = Double.parseDouble(sc.nextLine());
        double robesPrice = Double.parseDouble(sc.nextLine());
        double beltsPrice = Double.parseDouble(sc.nextLine());

        double lightsaberTotalPrice = Math.ceil(numberOfStudents * 1.1) * lightsaberPrice;
        double robesTotalPrice = numberOfStudents * robesPrice;

        numberOfStudents = getBeltsDiscount(numberOfStudents);
        double beltsTotalPrice = numberOfStudents * beltsPrice;

        double sum = lightsaberTotalPrice + robesTotalPrice + beltsTotalPrice;
        if (sum <= startingMoney) {
            System.out.printf("The money is enough - it would cost %.2flv.", sum);
        } else {
            double moneyNeeded = sum - startingMoney;
            System.out.printf("Ivan Cho will need %.2flv more.", moneyNeeded);
        }
    }

    private static int getBeltsDiscount(int discountStatement) {
        if (discountStatement >= 6 ) {
            int beltsDiscount = discountStatement / 6;
            discountStatement -= beltsDiscount;
        }
        return discountStatement;
    }
}
