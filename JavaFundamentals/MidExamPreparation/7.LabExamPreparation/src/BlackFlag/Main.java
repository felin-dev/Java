package BlackFlag;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int daysToPlunder = Integer.parseInt(sc.nextLine());
        double dailyPlunder = Double.parseDouble(sc.nextLine());
        double expectedPlunder = Double.parseDouble(sc.nextLine());

        double plunderToThisMoment = 0;
        for (int i = 1; i <= daysToPlunder; i++) {
            double currentDailyPlunder = dailyPlunder;
            if (i % 3 == 0) {
                currentDailyPlunder *= 1.5;
            }

            plunderToThisMoment += currentDailyPlunder;

            if (i % 5 == 0) {
                plunderToThisMoment = plunderToThisMoment * 0.7;
            }
        }

        if (plunderToThisMoment >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", plunderToThisMoment);
        } else {
            double percentOfTotalPlunder = plunderToThisMoment / expectedPlunder * 100;
            System.out.printf("Collected only %.2f%% of the plunder.", percentOfTotalPlunder);
        }
    }
}