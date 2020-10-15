import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String month = sc.nextLine();
        int hoursPassed = Integer.parseInt(sc.nextLine());
        int numberOfPeople = Integer.parseInt(sc.nextLine());
        String timeOfTheDay = sc.nextLine();

        double dayPricePerHour;
        double nightPricePerHour;
        switch (month) {
            case ("march"):
            case ("april"):
            case ("may"): {
                dayPricePerHour = 10.50;
                nightPricePerHour = 8.40;
                break;
            }
            case ("june"):
            case ("july"):
            case ("august"): {
                dayPricePerHour = 12.60;
                nightPricePerHour = 10.20;
                break;
            }
            default: {
                dayPricePerHour = 0;
                nightPricePerHour = 0;
                System.out.println("Error!");
            }
        }

        double pricePerPersonPerHour;
        if (timeOfTheDay.equals("day")) {
            pricePerPersonPerHour = dayPricePerHour;
        } else {
            pricePerPersonPerHour = nightPricePerHour;
        }

        if (numberOfPeople >= 4) {
            pricePerPersonPerHour *= 0.90;
        }

        if (hoursPassed >= 5) {
            pricePerPersonPerHour *= 0.50;
        }

        double pricePerPerson = pricePerPersonPerHour * hoursPassed;
        double totalPrice = pricePerPerson * numberOfPeople;
        System.out.printf("Price per person for one hour: %.2f%n", pricePerPersonPerHour);
        System.out.printf("Total cost of the visit: %.2f", totalPrice);
    }
}
