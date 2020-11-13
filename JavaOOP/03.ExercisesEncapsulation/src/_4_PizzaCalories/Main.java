package _4_PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] pizzaInfo = reader.readLine().split("\\s+");
        Pizza pizza = new Pizza(pizzaInfo[1], Integer.parseInt(pizzaInfo[2]));

        String[] doughInfo = reader.readLine().split("\\s+");
        Dough dough = new Dough(doughInfo[1], doughInfo[2], Double.parseDouble(doughInfo[3]));

        pizza.setDough(dough);

        String input;
        while (!(input = reader.readLine()).equals("END")) {
            String[] toppingInfo = input.split("\\s+");
            Topping topping = new Topping(toppingInfo[1], Double.parseDouble(toppingInfo[2]));
            pizza.addTopping(topping);
        }

        System.out.println(pizza);
    }
}
