import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class _5_ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        int n = Integer.parseInt(reader.readLine());

        numbers = numbers.stream().filter(num -> num % n != 0).collect(Collectors.toList());
        Collections.reverse(numbers);

        Consumer<List<Integer>> printer = list -> list.forEach(num -> System.out.printf("%s ", num));
        printer.accept(numbers);
    }
}
