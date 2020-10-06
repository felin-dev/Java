import java.util.ArrayDeque;

public class Intro {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(13);
        stack.push(42);
        stack.push(69);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.offer(13);
        queue.offer(42);
        queue.offer(69);
//
//        System.out.println(queue.size());
//
//        System.out.println(queue.poll());
//
//        System.out.println(queue.peek());
//
//        System.out.println(queue.size());

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
