import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _4_CountRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Double, Integer> numbers = new LinkedHashMap<>();
        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(n -> {
                    numbers.putIfAbsent(n, 0);
                    numbers.put(n, numbers.get(n) + 1);
                });

        numbers.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}