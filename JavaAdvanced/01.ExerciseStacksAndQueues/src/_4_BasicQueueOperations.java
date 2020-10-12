import java.util.ArrayDeque;
import java.util.Scanner;

public class _4_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tasks = sc.nextLine().split("\\s+");
        int n = Integer.parseInt(tasks[0]);
        int s = Integer.parseInt(tasks[1]);
        int x = Integer.parseInt(tasks[2]);

        String[] numbers = sc.nextLine().split("\\s+");
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.offer(Integer.valueOf(numbers[i]));
        }

        if (queue.size() >= s) {
            for (int j = 0; j < s; j++) {
                queue.poll();
            }
        }

        if (!queue.isEmpty()) {
            if (queue.contains(x)) {
                System.out.println("true");
            } else {
                printMinElement(queue);
            }
        } else {
            System.out.println("0");
        }
    }

    private static void printMinElement(ArrayDeque<Integer> queue) {
        int min = Integer.MAX_VALUE;
        for (Integer number : queue) {
            if (number < min) {
                min = number;
            }
        }

        System.out.println(min);
    }
}