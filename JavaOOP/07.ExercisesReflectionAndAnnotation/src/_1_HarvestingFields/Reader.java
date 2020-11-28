package _1_HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

    private final BufferedReader reader;

    public Reader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException exception) {
            throw new IllegalArgumentException(exception);
        }
    }
}
