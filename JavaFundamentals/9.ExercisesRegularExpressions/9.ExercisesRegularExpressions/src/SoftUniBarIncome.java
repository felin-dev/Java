import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regex = "%(?<customer>[A-Z][a-z]+)%[^|$%.]*?<(?<product>\\w+)>" +
                "[^|$%.]*?\\|(?<count>\\d+)\\|[^|$%.]*?(?<price>\\d+\\.?\\d+?)\\$";
        Pattern pattern = Pattern.compile(regex);

        double totalIncome = 0;
        String input = sc.nextLine();
        while (!"end of shift".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                double price;
                price = Double.parseDouble(matcher.group("count")) * Double.parseDouble(matcher.group("price"));
                totalIncome += price;
                System.out.println(String.format("%s: %s - %.2f", matcher.group("customer"), matcher.group("product"), price));
            }

            input = sc.nextLine();
        }

        System.out.println(String.format("Total income: %.2f", totalIncome));
    }
}