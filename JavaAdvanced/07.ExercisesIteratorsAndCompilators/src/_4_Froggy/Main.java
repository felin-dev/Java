package _4_Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Lake frog = new Lake(Arrays.stream(reader.readLine().split(",\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList()));

        StringJoiner output = new StringJoiner(", ");
        for (Integer jumps : frog) {
            output.add(String.valueOf(jumps));
        }

        System.out.println(output);
    }
}
