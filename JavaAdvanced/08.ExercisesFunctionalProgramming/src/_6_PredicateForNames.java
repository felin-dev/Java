import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _6_PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nameLength = Integer.parseInt(reader.readLine());
        List<String> people = Arrays.stream(reader.readLine().split("\\s+"))
                .map(String::toString)
                .collect(Collectors.toList());

        people = people.stream().filter(name -> name.length() <= nameLength).collect(Collectors.toList());
        people.forEach(System.out::println);
    }
}
