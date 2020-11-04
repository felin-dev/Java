package _5_JediGalaxyBuffered;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class InputParser {

    private final BufferedReader reader;

    public InputParser(BufferedReader reader) {
        this.reader = reader;
    }

    public int[] parseDimensions() {
        return parseIntegers();
    }

    public String parseCommand() {
        return readLine();
    }

    public int[] parseCoordinates() {
        return parseIntegers();
    }

    private int[] parseIntegers() {
        return Arrays.stream(readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }

    private String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
