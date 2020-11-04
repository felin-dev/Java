package _5_JediGalaxyBuffered;

import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.function.Predicate.isEqual;

public class CommandProcessor {

    private final Galaxy galaxy;
    private final InputParser inputParser;

    public CommandProcessor(Galaxy galaxy, InputParser inputParser) {
        this.galaxy = galaxy;
        this.inputParser = inputParser;
    }

    public void processCommands() {
        Stream.generate(inputParser::parseCommand)
                .takeWhile(isEqual("Let the Force be with you").negate())
                .forEach(command -> {
                    int[] jediIvoCoordinates = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
                    int[] evilCoordinates = inputParser.parseCoordinates();

                    galaxy.destroyStars(evilCoordinates[0], evilCoordinates[1]);
                    galaxy.collectStars(jediIvoCoordinates[0], jediIvoCoordinates[1]);
                });
    }
}
