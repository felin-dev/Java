package Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Box<Double> box = new Box<Double>();
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            double input = Double.parseDouble(reader.readLine());
            box.add(input);
        }

        box.count(Double.valueOf(reader.readLine()));
    }
}
