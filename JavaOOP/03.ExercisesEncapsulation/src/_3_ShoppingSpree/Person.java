package _3_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private final List<Product> products;

    public Person (String name,  double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    private void setName(String name) {
        NameValidator.validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setMoney (double money) {
        NotNegativeDoubleValidator.validate(money);
        this.money = money;
    }

    public void buyProduct (Product product) {
        if (product.getCost() > money) {
            throw new IllegalArgumentException(String.format("%s can't afford %s%n", name, product.getName()));
        } else {
            products.add(product);
            setMoney(money - product.getCost());
            System.out.printf("%s bought %s%n", name, product.getName());
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s - ", name));
        if (products.isEmpty()) {
            output.append("Nothing bought");
        } else {
            output.append(products.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        return output.toString().trim();
    }
}
