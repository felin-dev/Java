import java.util.*;

public class _6_ProductShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, Double>> shops = new TreeMap<>();
        String input = sc.nextLine();
        while (!input.equals("Revision")) {
            String[] shopInfo = input.split(",\\s+");
            String shopName = shopInfo[0];
            String productName = shopInfo[1];
            Double productPrice = Double.valueOf(shopInfo[2]);
            shops.putIfAbsent(shopName, new LinkedHashMap<>());
            shops.get(shopName).put(productName, productPrice);

            input = sc.nextLine();
        }

        StringBuilder output = new StringBuilder();
        shops.forEach((shop, products) -> {
            output.append(String.format("%s->%n", shop));
            products.forEach((product, price) -> output.append(String.format("Product: %s, Price: %.1f%n", product, price)));
        });

        System.out.println(output);
    }
}