import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int numberOfKids = 0;
        int numberOfAdults = 0;
        while (!input.equals("Christmas")) {
            int years = Integer.parseInt(input);
            if (years <= 16) {
                numberOfKids++;
            } else {
                numberOfAdults++;
            }

            input = sc.nextLine();
        }
        int priceForToys = numberOfKids * 5;
        int priceForSweaters = numberOfAdults * 15;
        int totalPrice = priceForSweaters + priceForToys;

        System.out.printf("Number of adults: %d%n", numberOfAdults);
        System.out.printf("Number of kids: %d%n", numberOfKids);
        System.out.printf("Money for toys: %d%n", priceForToys);
        System.out.printf("Money for sweaters: %d%n", priceForSweaters);
    }
}
