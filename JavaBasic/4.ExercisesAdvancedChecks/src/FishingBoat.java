import java.util.Scanner;

public class FishingBoat {
    public static final double WINTER_RENT = 2600;
    public static final double SUMMER_AUTUMN_RENT = 4200;
    public static final double SPRING_RENT = 3000;

    public static final double FISHERMEN_DISCOUNT = 0.95;
    public static final double UNDER_OR_EQUAL_SIX_PEOPLE_DISCOUNT = 0.90;
    public static final double SEVEN_TO_ELEVEN_PEOPLE_DISCOUNT = 0.85;
    public static final double TWELVE_PEOPLE_DISCOUNT = 0.75;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int budged = Integer.parseInt(sc.nextLine());
        String season = sc.nextLine();
        int fishermen = Integer.parseInt(sc.nextLine());


        double seasonRent =0;
        seasonRent = getSeasonRent(season);

        double expenses = 0;
        if (fishermen <= 6){
            expenses = seasonRent * UNDER_OR_EQUAL_SIX_PEOPLE_DISCOUNT;
        }

        if (fishermen > 6 && fishermen <=11){
            expenses = seasonRent * SEVEN_TO_ELEVEN_PEOPLE_DISCOUNT;
        }

        if (fishermen >= 12){
            expenses = seasonRent * TWELVE_PEOPLE_DISCOUNT;
        }

        if (fishermen % 2 == 0 && !season.equals("Autumn")){
            expenses = expenses * FISHERMEN_DISCOUNT;
        }

        if (budged >= expenses){
            double enoughMoney = budged - expenses;
            System.out.printf("Yes! You have %.2f leva left.", enoughMoney);
        } else {
            double notEnoughMoney = expenses - budged;
            System.out.printf("Not enough money! You need %.2f leva.", notEnoughMoney);
        }
    }

    private static double getSeasonRent(String season) {
        double seasonRent;
        switch (season){
            case "Winter":
                seasonRent = WINTER_RENT;
                break;
            case "Spring":
                seasonRent = SPRING_RENT;
                break;
            case "Summer":
            case "Autumn":
                seasonRent = SUMMER_AUTUMN_RENT;
                break;
            default: throw new IllegalArgumentException("You have entered incorrect season!");
        }
        return seasonRent;
    }
}
