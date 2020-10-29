import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _1_Scheduling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);

        Deque<Integer> queue = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(queue::offer);

        int killingTask = Integer.parseInt(reader.readLine());

        while (!stack.isEmpty() && !queue.isEmpty()) {
            int thread = queue.peek();
            int task = stack.peek();

            if (task == killingTask) {
                StringBuilder output = new StringBuilder();
                output.append(String.format("Thread with value %d killed task %d%n", thread, task));
                while (!queue.isEmpty()) {
                    output.append(queue.poll()).append(" ");
                }
                System.out.println(output);
                break;
            }
            if (thread >= task) {
                queue.poll();
                stack.pop();
            } else {
                queue.poll();
            }


                //•	If the thread value is greater than or equal to the task value,
                // the task and thread get removed.
            //•	If the thread value is less than the task value, the thread gets removed, but the task remains.
        }
        System.out.println();
    }
}
