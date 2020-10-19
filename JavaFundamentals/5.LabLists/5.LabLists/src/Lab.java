import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        System.out.println(strings.size());

        strings.add(0, "First");
        strings.add("Second");
        strings.add("Third");
        strings.remove("First");

        System.out.println(strings.size());

        System.out.println(String.join(", ", strings));

        List<Integer> numbers = new ArrayList<>();
        numbers.add(25);
        numbers.add(35);
        numbers.add(55);
        numbers.remove(Integer.valueOf(25));

        for (int number : numbers) {
            System.out.println(number);
        }
        Scanner sc = new Scanner(System.in);

        List<Double> floatingNumbers = Arrays
                .stream(sc.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        System.out.println(floatingNumbers);
    }
}
