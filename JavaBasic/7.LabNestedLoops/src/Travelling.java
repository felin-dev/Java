import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String destination = sc.nextLine();
        while (!"End".equals(destination)) {
            double target = Double.parseDouble(sc.nextLine());
            double currentSum = 0;
            while (currentSum < target) {
                double money = Double.parseDouble(sc.nextLine());
                currentSum += money;
            }
            System.out.printf("Going to %s!%n", destination);
            destination = sc.nextLine();
        }
    }
}
