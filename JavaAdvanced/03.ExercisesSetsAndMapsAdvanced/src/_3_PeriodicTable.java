import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _3_PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int times = Integer.parseInt(sc.nextLine());
        Set<String> elements = new TreeSet<>();
        while (times-- > 0) {
            String[] input = sc.nextLine().split("\\s+");
            elements.addAll(Arrays.asList(input));
        }

        StringBuilder output = new StringBuilder();
        elements.forEach(e -> output.append(e).append(" "));
        System.out.println(output);
    }
}