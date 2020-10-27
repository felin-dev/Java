import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class _8_CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Consumer<Integer> printer = number -> System.out.printf("%d ", number);
        Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .sorted(new Comparator())
                .forEach(printer);
    }

    public static class Comparator implements java.util.Comparator<Integer> {
        @Override
        public int compare(Integer numberOne, Integer numberTwo) {
            if (numberOne % 2 == 0 && numberTwo % 2 == 0) {
                return numberOne - numberTwo;
            } else if (numberOne % 2 == 0) {
                return -1;
            } else if (numberTwo % 2 == 0) {
                return 1;
            } else {
                return numberOne - numberTwo;
            }
        }
    }
}
