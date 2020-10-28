import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class _1_SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        IntPredicate filter = number -> number % 2 == 0;
        String input = reader.readLine();
        String output = Arrays.stream(input.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(filter)
                .boxed()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        System.out.println(output);

        output = Arrays.stream(input.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(filter)
                .sorted()
                .boxed()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        System.out.println(output);
    }
}
