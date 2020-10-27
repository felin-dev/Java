import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _7_FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> getMinElementIndex = list -> {
            int minIndex = 0;
            int minElement = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (minElement >= list.get(i)) {
                    minIndex = i;
                    minElement = list.get(i);
                }
            }

            return minIndex;
        };

        System.out.println(getMinElementIndex.apply(numbers));
    }
}
