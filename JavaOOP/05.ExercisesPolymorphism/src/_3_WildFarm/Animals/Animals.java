package _3_WildFarm.Animals;

import java.util.LinkedHashMap;
import java.util.Map;

public class Animals {

    private final Map<String, Animal> animals;

    public Animals() {
        this.animals = new LinkedHashMap<>();
    }

    public void put(String animalType, String[] animalInfo) {
        animals.put(animalType, createNewAnimal(animalInfo));
    }

    public Animal get(String animalType) {
        return animals.get(animalType);
    }

    private Animal createNewAnimal(String[] tokens) {
        switch (tokens[0]) {
            case "Mouse":
                return new Mouse(tokens[0], tokens[1], Double.parseDouble(tokens[2]), tokens[3]);
            case "Zebra":
                return new Zebra(tokens[0], tokens[1], Double.parseDouble(tokens[2]), tokens[3]);
            case "Cat":
                return new Cat(tokens[0], tokens[1], Double.parseDouble(tokens[2]), tokens[3], tokens[4]);
            case "Tiger":
                return new Tiger(tokens[0], tokens[1], Double.parseDouble(tokens[2]), tokens[3]);
            default:
                throw new IllegalArgumentException("There is no such animal in the known animal list.");
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        animals.values().forEach(animal -> {
            output.append(animal.toString());
            output.append(System.lineSeparator());
        });

        return output.toString().trim();
    }
}
