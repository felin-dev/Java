package _2_blackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

    private final BufferedReader reader;

    public Reader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String[] readSplitLine(String regex) {
        return readLineFromReader().split(regex);
    }

    public String readLine() {
        return readLineFromReader();
    }

    private String readLineFromReader() {
        try {
            return reader.readLine();
        } catch (IOException exception) {
            throw new IllegalArgumentException(exception);
        }
    }
}
