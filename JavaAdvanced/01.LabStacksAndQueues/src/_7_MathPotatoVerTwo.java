import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _7_MathPotatoVerTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> kids = Arrays
                .stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        int n = Integer.parseInt(sc.nextLine());
        int currentCycle = 1;
        while (kids.size() > 1) {
            for (int timesToJump = n - 1; timesToJump > 0; timesToJump--) {
                if (!kids.isEmpty()) {
                    kids.offer(kids.poll());
                }
            }
            if (!isPrime(currentCycle)) {
                System.out.println("Removed " + kids.poll());
            } else {
                System.out.println("Prime " + kids.peek());
            }

            currentCycle++;
        }

        System.out.print("Last is " + kids.poll());
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2, sqrt = (int) Math.sqrt(n); i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}