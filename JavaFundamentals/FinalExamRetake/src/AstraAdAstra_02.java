import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AstraAdAstra_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String regex = "([#|])(?<food>[A-Za-z\\s+]+)\\1(?<expirationDate>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>\\d+)\\1";
        String foodInfo = sc.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher caloriesMatcher = pattern.matcher(foodInfo);
        Matcher matcher = pattern.matcher(foodInfo);
        int calories = 0;
        while (caloriesMatcher.find()) {
            int currentCalories = Integer.parseInt(caloriesMatcher.group("calories"));
            calories += currentCalories;
        }

        int days = 0;
        if (calories > 2000) {
            days = calories / 2000;
        }
        System.out.println(String.format("You have food to last you for: %d days!", days));

        while (matcher.find()) {
            System.out.println(String.format("Item: %s, Best before: %s, Nutrition: %s",
                    matcher.group("food"), matcher.group("expirationDate"), matcher.group("calories")));
        }
    }
}