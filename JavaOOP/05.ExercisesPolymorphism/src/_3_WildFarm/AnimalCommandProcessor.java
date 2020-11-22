package _3_WildFarm;

import _3_WildFarm.Animals.Animal;
import _3_WildFarm.Food.Food;
import _3_WildFarm.Food.Meat;
import _3_WildFarm.Food.Vegetable;
import _3_WildFarm.Utilities.InputParser;

public class AnimalCommandProcessor {

    private final InputParser reader;
    private final AnimalsList animalsList;

    public AnimalCommandProcessor(InputParser reader, AnimalsList animalsList) {
        this.reader = reader;
        this.animalsList = animalsList;
    }

    public void processCommands() {
        String command;
        while (!(command = reader.parseCommand()).equals("End")) {
            String[] animalInfo = command.split("\\s+");
            String[] foodInfo = reader.parseSplitCommand("\\s+");
            Animal animal = animalsList.createNewAnimal(animalInfo);
            animalsList.add(animal);
            animal.makeSound();

            try {
                animal.eat(getFood(foodInfo));
            } catch (IllegalStateException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private Food getFood(String[] foodInfo) {
        return foodInfo[0].equals("Vegetable") ?
                new Vegetable(Integer.parseInt(foodInfo[1])) :
                new Meat(Integer.parseInt(foodInfo[1]));
    }
}
