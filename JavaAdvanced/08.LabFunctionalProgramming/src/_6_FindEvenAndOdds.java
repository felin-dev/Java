import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class _6_FindEvenAndOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] rangeOfNumbers = reader.readLine().split("\\s+");
        int startingNumber = Integer.parseInt(rangeOfNumbers[0]);
        int endingNumber = Integer.parseInt(rangeOfNumbers[1]);
        boolean even = reader.readLine().equals("even");
        StringJoiner output = new StringJoiner(" ");
        IntStream.range(startingNumber, endingNumber + 1)
                .filter(predicate(even))
                .forEach(consumer(output)::accept);

        System.out.println(output);
    }

    public static Consumer<Integer> consumer(StringJoiner output) {
        return num -> output.add(String.valueOf(num));
    }

    public static IntPredicate predicate(boolean even) {
        if (even) {
            return num -> num % 2 == 0;
        } else {
            return num -> num % 2 != 0;
        }
    }
}
