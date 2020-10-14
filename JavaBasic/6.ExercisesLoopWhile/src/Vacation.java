import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double neededMoney = Double.parseDouble(sc.nextLine());
        double currentMoney = Double.parseDouble(sc.nextLine());

        int totalDaysCount = 0;
        int daysSpent = 0;
        while (currentMoney < neededMoney) {
            String command = sc.nextLine();
            double dayMoney = Double.parseDouble(sc.nextLine());
            totalDaysCount++;

            if (command.equals("save")) {
                currentMoney += dayMoney;
                daysSpent = 0;
            } else if (command.equals("spend")) {
                currentMoney = Math.max(0, currentMoney - dayMoney);
                daysSpent++;
            }

            if (daysSpent == 5) {
                break;
            }
        }

        if (neededMoney <= currentMoney) {
            System.out.printf("You saved the money for %d days.", totalDaysCount);
        } else {
            System.out.printf("You can't save the money.%n%d", totalDaysCount);
        }
    }
}
