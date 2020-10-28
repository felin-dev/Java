import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class _3_CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        int[] wordCounter = new int[1];
        StringBuilder output = new StringBuilder();
        Consumer<String> consumer = word -> {
            output.append(word).append(System.lineSeparator());
            wordCounter[0]++;
        };

        Arrays.stream(input.split("\\s+"))
                .map(String::toString)
                .filter(word -> Character.isUpperCase(word.charAt(0)))
                .forEach(consumer);

        System.out.println(wordCounter[0]);
        System.out.println(output);
    }
}
