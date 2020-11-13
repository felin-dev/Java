package _3_ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] peopleInfo = reader.readLine().split(";");
        List<Person> people = new ArrayList<>();
        for (String personInfo : peopleInfo) {
            people.add(new Person(personInfo.split("=")[0],
                    Double.parseDouble(personInfo.split("=")[1])));
        }
        String[] productsInfo = reader.readLine().split(";");
        List<Product> products = new ArrayList<>();
        for (String productInfo : productsInfo) {
            products.add(new Product(productInfo.split("=")[0],
                    Double.parseDouble(productInfo.split("=")[1])));
        }

        String input;
        while (!(input = reader.readLine()).equals("END")) {
            String[] shoppingCart = input.split("\\s+");

            for (Person person : people) {
                if (person.getName().equals(shoppingCart[0])) {
                    for (Product product : products) {
                        if (product.getName().equals(shoppingCart[1])) {
                            person.buyProduct(product);
                        }
                    }
                }
            }
        }

        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}
