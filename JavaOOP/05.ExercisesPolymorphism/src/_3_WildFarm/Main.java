package _3_WildFarm;

import _3_WildFarm.Utilities.DecimalFormatter;
import _3_WildFarm.Utilities.InputParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        DecimalFormatter.setFormat('.', "##.##");
        InputParser inputParser = new InputParser(new BufferedReader(new InputStreamReader(System.in)));
        AnimalsList animalsList = new AnimalsList();
        AnimalCommandProcessor animalCommandProcessor = new AnimalCommandProcessor(inputParser, animalsList);

        animalCommandProcessor.processCommands();

        animalsList.printAnimals();
    }
}
