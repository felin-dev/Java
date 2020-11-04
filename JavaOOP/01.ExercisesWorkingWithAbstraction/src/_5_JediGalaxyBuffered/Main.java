package _5_JediGalaxyBuffered;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        InputParser inputParser = new InputParser(new BufferedReader(new InputStreamReader(System.in)));
        int[] dimensions = inputParser.parseDimensions();
        Galaxy galaxy = new Galaxy(dimensions[0], dimensions[1]);
        CommandProcessor commandProcessor = new CommandProcessor(galaxy, inputParser);

        commandProcessor.processCommands();

        System.out.println(galaxy.getTotalStarsCollected());
    }
}
