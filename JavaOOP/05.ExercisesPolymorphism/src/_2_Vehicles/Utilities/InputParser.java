package _2_Vehicles.Utilities;


import java.io.BufferedReader;

public class InputParser {

    private final BufferedReader reader;

    public InputParser(BufferedReader reader) {
        this.reader = reader;
    }

    public String parseCommand() {
        return readLine();
    }

    public String[] parseSplitCommand(String regex) {
        return readLine().split(regex);
    }

    private String readLine() {
        try {
            return reader.readLine();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
