import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _9_ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        int[] ints = IntStream.range(1, n + 1).filter(getDivisibleNumbers(numbers)).toArray();

        printer(ints);
    }

    private static void printer(int[] numbers) {
        StringBuilder output = new StringBuilder();
        for (int number : numbers) {
            output.append(number).append(" ");
        }

        System.out.println(output.toString().trim());
    }

    private static IntPredicate getDivisibleNumbers(List<Integer> numbers) {
        return i -> {
            boolean dividable = true;
            for (Integer number : numbers) {
                if (i % number != 0) {
                    dividable = false;
                    break;
                }
            }

            return dividable;
        };
    }
}
