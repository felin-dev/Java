import java.util.ArrayDeque;
import java.util.Scanner;

public class _4_MatchingBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String expression = sc.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);

            if (symbol == '(') {
                stack.push(i);
            } else if (symbol == ')' && !stack.isEmpty()) {
                int openingIndex = stack.pop();
                int closingIndex = i;
                System.out.println(expression.substring(openingIndex, closingIndex + 1));
            }
        }
    }
}