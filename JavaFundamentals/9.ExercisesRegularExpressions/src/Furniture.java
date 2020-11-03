import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regex = ">>(?<product>[A-Za-z]+)<<(?<price>\\d+\\.?\\d+)!(?<quantity>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        List<String> products = new ArrayList<>();
        double totalMoneySpend = 0.0;
        String input = sc.nextLine();
        while (!"Purchase".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                products.add(matcher.group("product"));
                totalMoneySpend += Double.parseDouble(matcher.group("price")) *
                        Integer.parseInt(matcher.group("quantity"));
            }

            input = sc.nextLine();
        }

        System.out.println("Bought furniture:");
        products
                .forEach(p -> System.out.println(String.format("%s", p)));
        System.out.println(String.format("Total money spend: %.2f", totalMoneySpend));
    }
}