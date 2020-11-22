package _3_WildFarm;

import _3_WildFarm.Animals.*;

import java.util.ArrayList;
import java.util.List;

public class AnimalsList {

    private final List<Animal> animals;

    public AnimalsList() {
        this.animals = new ArrayList<>();
    }

    public void add(Animal animal) {
        animals.add(animal);
    }

    public void printAnimals() {
        System.out.println(toString());
    }

    public Animal createNewAnimal(String[] tokens) {
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
        animals.forEach(animal -> {
            output.append(animal.toString());
            output.append(System.lineSeparator());
        });

        return output.toString().trim();
    }
}
