import java.util.ArrayDeque;
import java.util.Scanner;

public class _2_BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tasks = sc.nextLine().split("\\s+");
        int n = Integer.parseInt(tasks[0]);
        int s = Integer.parseInt(tasks[1]);
        int x = Integer.parseInt(tasks[2]);

        String[] numbers = sc.nextLine().split("\\s+");

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            numbersStack.push(Integer.parseInt(numbers[i]));
        }

        if (numbers.length >= s) {
            for (int j = 0; j < s; j++) {
                numbersStack.pop();
            }
        }

        if (numbersStack.contains(x)) {
            System.out.println("true");
        } else {
            printSmallestElement(numbersStack);
        }
    }

    private static void printSmallestElement(ArrayDeque<Integer> numbersStack) {
        int min = Integer.MAX_VALUE;
        if (!numbersStack.isEmpty()) {
            for (Integer number : numbersStack) {
                if (number < min) {
                    min = number;
                }
            }
            System.out.println(min);
        } else {
            System.out.println("0");
        }
    }
}