import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class _4_AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], int[]> add = numbers -> Arrays.stream(numbers).map(num -> num += 1).toArray();
        Function<int[], int[]> multiply = numbers -> Arrays.stream(numbers).map(num -> num *= 2).toArray();
        Function<int[], int[]> subtract = numbers -> Arrays.stream(numbers).map(num -> num -= 1).toArray();
        Consumer<int[]> print = numbers -> Arrays.stream(numbers).forEach(num -> System.out.printf("%s ", num));

        String command = reader.readLine();
        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    array = add.apply(array);
                    break;
                case "multiply":
                    array = multiply.apply(array);
                    break;
                case "subtract":
                    array = subtract.apply(array);
                    break;
                case "print":
                    print.accept(array);
                    System.out.println();
                    break;
            }

            command = reader.readLine();
        }
    }
}
