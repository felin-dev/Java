package _4_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza (String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
        toppings = new ArrayList<>();
    }

    private void setName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.trim().isEmpty() || name.length() > 15 || name.length() < 1) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    private void setToppings(int numberOfToppings) {
        validateNumberOfToppings(numberOfToppings);
    }

    private void validateNumberOfToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public String getName() {
        return name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping (Topping topping) {
        toppings.add(topping);
    }

    public double getOverallCalories() {
        double calories = dough.calculateCalories();
        for (Topping topping : toppings) {
            calories += topping.calculateCalories();
        }

        return calories;
    }

    @Override
    public String toString() {
        return name + " - " + getOverallCalories();
    }
}
