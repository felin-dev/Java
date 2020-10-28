import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class _4_AddVat {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        Function<String, Double> function = num -> Double.parseDouble(num) * 1.2;
        Consumer<Double> consumer = num -> System.out.printf("%.2f%n", num);
        System.out.println("Prices with VAT:");
        Arrays.stream(input.split(",\\s+"))
                .map(function)
                .forEach(consumer);
    }
}
