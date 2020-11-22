package _3_WildFarm.Animals;

import _3_WildFarm.Food.Food;
import _3_WildFarm.Food.Meat;

public class Zebra extends Mammal {

    public Zebra(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            throw new IllegalStateException("Zebras are not eating that type of food!");
        } else {
            super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
        }
    }
}
