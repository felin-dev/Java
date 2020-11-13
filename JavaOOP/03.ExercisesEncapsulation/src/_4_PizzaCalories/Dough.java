package _4_PizzaCalories;

import java.util.Map;

public class Dough {

    private static final Map<String, Double> TYPE_MODIFIERS = Map.of(
            "White", 1.5,
            "Wholegrain", 1.0
    );

    private static final Map<String, Double> BAKING_TECHNIQUE_MODIFIERS = Map.of(
            "Crispy", 0.9,
            "Chewy", 1.1,
            "Homemade", 1.0

    );

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough (String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }


    private void setFlourType(String flourType) {
        validateType(flourType);
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        validateType(bakingTechnique);
        this.bakingTechnique = bakingTechnique;
    }

    private void validateType(String flourType) {
        if (!TYPE_MODIFIERS.containsKey(flourType) &&
                !BAKING_TECHNIQUE_MODIFIERS.containsKey(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        validateWeight(weight);
        this.weight = weight;
    }

    private void validateWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public double calculateCalories() {
        return (2 * weight) * TYPE_MODIFIERS.get(flourType) * BAKING_TECHNIQUE_MODIFIERS.get(bakingTechnique);
    }
}
