import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _6_HotPotatoVerTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> kids = Arrays
                .stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        int n = Integer.parseInt(sc.nextLine());
        while (kids.size() > 1) {
            for (int timesToJump = n - 1; timesToJump > 0; timesToJump--) {
                if (!kids.isEmpty()) {
                    kids.offer(kids.poll());
                }
            }
            System.out.println("Removed " + kids.poll());
        }

        System.out.println("Last is " + kids.poll());
    }
}