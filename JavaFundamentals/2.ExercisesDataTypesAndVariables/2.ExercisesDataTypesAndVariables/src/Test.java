import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int startingYield = Integer.parseInt(sc.nextLine());
        int farmedSpice = 0;
        int numberOfDays = 0;
        if (startingYield >= 100) {

            numberOfDays = ((startingYield - 100) / 10 + 1);
            farmedSpice = (startingYield + 100 + startingYield % 10) / 2 * numberOfDays - numberOfDays * 26 - 26;
        }

        System.out.printf("%d%n", numberOfDays);
        System.out.printf("%d", farmedSpice);
    }
}
