import java.util.Scanner;

public class TradeCommissions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String town = sc.nextLine();
        double sells = Double.parseDouble(sc.nextLine());

        double commission = 0;
        switch (town) {
            case "Sofia": {
                if (sells <= 500) {
                    commission = sells * 0.05;
                }
                if (sells > 500 && sells <= 1000) {
                    commission = sells * 0.07;
                }
                if (sells > 1000 && sells <= 10000) {
                    commission = sells * 0.08;
                }
                if (sells > 10000) {
                    commission = sells * 0.12;
                }
                break;
            }
            case "Varna": {
                if (sells <= 500) {
                    commission = sells * 0.045;
                }
                if (sells > 500 && sells <= 1000) {
                    commission = sells * 0.075;
                }
                if (sells > 1000 && sells <= 10000) {
                    commission = sells * 0.1;
                }
                if (sells > 10000) {
                    commission = sells * 0.13;
                }
                break;
            }
            case "Plovdiv": {
                if (sells <= 500) {
                    commission = sells * 0.055;
                }
                if (sells > 500 && sells <= 1000) {
                    commission = sells * 0.08;
                }
                if (sells > 1000 && sells <= 10000) {
                    commission = sells * 0.12;
                }
                if (sells > 10000) {
                    commission = sells * 0.145;
                }
                break;
            }
            default:
                System.out.println("");
                break;
        }
        if (commission > 0) {
            System.out.printf("%.2f", commission);
        } else {
            System.out.println("error");
        }
    }
}
