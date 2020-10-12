import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _1_ReverseNumbersStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        Arrays
                .stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer :: parseInt)
                .forEach(numbers :: push);

        while (!numbers.isEmpty()) {
            System.out.print(numbers.pop() + " ");
        }
    }
}