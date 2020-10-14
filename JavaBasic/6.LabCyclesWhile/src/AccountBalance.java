import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int payments = Integer.parseInt(sc.nextLine());

        int i = 0;
        double balance = 0;
        while (i < payments) {
            double currentPayment = Double.parseDouble(sc.nextLine());
            if (currentPayment < 0) {
                System.out.println("Invalid operation!");
                break;
            }
            System.out.printf("Increase: %.2f%n", currentPayment);
            balance += currentPayment;
            i++;
        }
        System.out.printf("Total: %.2f", balance);
    }
}
