package _1_Vehicles.Utilities;

import java.io.InputStreamReader;

public class BufferedReader {
    private static final java.io.BufferedReader reader = new
            java.io.BufferedReader(new InputStreamReader(System.in));

    public static String readLine() {
        try {
            return reader.readLine();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
