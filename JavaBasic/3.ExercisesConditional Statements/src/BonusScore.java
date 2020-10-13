import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());
        double result = 0;
        double bonus1 = 0;
        double bonus2 = 0;
        double bonus = 0;

        if (number % 10 == 5) {
            bonus1 = bonus1 + 2;
        } else if (number % 2 == 0) {
            bonus1 = bonus1 + 1;
        }

        if (number <= 100) {
            bonus2 = bonus + 5;
        } else if (number > 1000) {
            bonus2 = number * 0.1;
        } else {
            bonus2 = number * 0.2;
        }
        bonus = bonus1 + bonus2;
        result = bonus + number;
        System.out.println(bonus);
        System.out.println(result);
    }
}
