package _3_WildFarm.Animals;

import _3_WildFarm.Food.Food;
import _3_WildFarm.Utilities.DecimalFormatter;

public class Cat extends Felime {

    private final String breed;

    public Cat(String animalType, String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]", super.animalType, super.animalName,
                breed,
                DecimalFormatter.format(super.animalWeight),
                super.livingRegion, super.foodEaten);
    }
}
