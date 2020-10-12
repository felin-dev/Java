import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _3_MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tasks = Integer.parseInt(sc.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < tasks; i++) {
            String[] command = sc.nextLine().split("\\s+");
            int number = Integer.parseInt(command[0]);
            switch (number) {
                case 1:
                    int numberToPush = Integer.parseInt(command[1]);
                    stack.push(numberToPush);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.println(Collections.max(stack));
                    break;
            }
        }
    }
}