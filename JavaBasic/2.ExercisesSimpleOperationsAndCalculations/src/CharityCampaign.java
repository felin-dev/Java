import java.util.Scanner;

public class CharityCampaign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double activeDays = Double.parseDouble(sc.nextLine());
        double cooks = Double.parseDouble(sc.nextLine());
        double cakes = Double.parseDouble(sc.nextLine());
        double quadcakes = Double.parseDouble(sc.nextLine());
        double pancakes = Double.parseDouble(sc.nextLine());
        double cakesPrice = 45;
        double quadcakePrice = 5.80;
        double pancakesPrice = 3.20;
        double cakesIncome = cakes * cakesPrice;
        double quadcakesIncome = quadcakes * quadcakePrice;
        double pankakesIncome = pancakes * pancakesPrice;
        double dailyIncome = (cakesIncome + quadcakesIncome + pankakesIncome)
                * cooks;
        double income = dailyIncome * activeDays;
        double expenses = income / 8;
        double incomeAfterExpenses = income - expenses;
        System.out.printf("%.2f", incomeAfterExpenses);
    }
}
