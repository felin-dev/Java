import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _2_SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] dimensions = sc.nextLine().split("\\s+");
        int firstSize = Integer.parseInt(dimensions[0]);
        int secondSize = Integer.parseInt(dimensions[1]);

        Set<Integer> firstRowOfNumbers = new LinkedHashSet<>(firstSize);
        for (int i = 0; i < firstSize; i++) {
            firstRowOfNumbers.add(Integer.valueOf(sc.nextLine()));
        }

        Set<Integer> secondRowOfNumbers = new LinkedHashSet<>(secondSize);
        for (int i = 0; i < secondSize; i++) {
            secondRowOfNumbers.add(Integer.valueOf(sc.nextLine()));
        }

        firstRowOfNumbers.retainAll(secondRowOfNumbers);
        firstRowOfNumbers.forEach(e -> System.out.print(e + " "));
    }
}