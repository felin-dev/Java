package _3_WildFarm.Animals;

import _3_WildFarm.Food.Food;
import _3_WildFarm.Utilities.DecimalFormatter;

public abstract class Animal {

    protected final String animalType;
    protected final String animalName;
    protected final Double animalWeight;
    protected final String livingRegion;
    protected Integer foodEaten;

    protected Animal(String animalType, String animalName, Double animalWeight, String livingRegion) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        this.livingRegion = livingRegion;
        setFoodEaten(0);
    }

    protected void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    public abstract void makeSound();

    public abstract void eat(Food food);

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]", animalType, animalName,
                DecimalFormatter.format(animalWeight),
                livingRegion, foodEaten);
    }
}
