package _4_PizzaCalories;

import java.util.Map;

public class Topping {

    private static final Map<String, Double> TOPPING_MODIFIERS = Map.of(
            "Meat", 1.2,
            "Veggies", 0.8,
            "Cheese", 1.1,
            "Sauce", 0.9

    );

    private String toppingType;
    private double weight;

    public Topping (String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        validateTopping(toppingType);
        this.toppingType = toppingType;
    }

    private void validateTopping(String toppingType) {
        if (!TOPPING_MODIFIERS.containsKey(toppingType)) {
            throw new IllegalArgumentException("Cannot place "
                    + toppingType + " on top of your pizza.");
        }
    }

    private void setWeight(double weight) {
        validateWeight(weight);
        this.weight = weight;
    }

    private void validateWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(toppingType + " weight should be in the range [1..50].");
        }
    }

    public double calculateCalories() {
        return (2 * weight) * TOPPING_MODIFIERS.get(toppingType);
    }
}
