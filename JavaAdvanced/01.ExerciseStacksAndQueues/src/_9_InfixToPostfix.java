import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class _9_InfixToPostfix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder output = new StringBuilder();
        Map<Character, Integer> symbols = Map.of(
                '+', 2, '-', 2,
                '*', 3, '/', 3,
                '(', 1, ')', 1
        );
        Deque<Character> stack = new ArrayDeque<>();
        String[] line = reader.readLine().split("\\s+");
        for (String symbol : line) {
            if (symbol.length() > 1) {
                output.append(symbol);
                output.append(" ");
                continue;
            }

            char currentChar = symbol.charAt(0);
            if (symbols.containsKey(currentChar)) {
                if (stack.size() > 0) {
                    Character stackChar = stack.peek();
                    if (currentChar == '(') {
                        stack.push(currentChar);
                    } else if (currentChar == ')') {
                        if (stack.contains('(')) {
                            while (stack.size() > 0 && stack.peek() != '(') {
                                output.append(stack.pop());
                                output.append(" ");
                            }

                            stack.pop();
                        }
                    } else if (symbols.get(currentChar) > symbols.get(stackChar)) {
                        stack.push(currentChar);
                    } else if (symbols.get(currentChar) < symbols.get(stackChar)) {
                        output.append(stack.pop()).append(" ");
                        stack.push(currentChar);
                    } else if (symbols.get(currentChar).equals(symbols.get(stackChar))) {
                        output.append(stack.pop());
                        output.append(" ");
                        stack.push(currentChar);
                    }
                } else {
                    stack.push(currentChar);
                }
            } else {
                output.append(currentChar).append(" ");
            }
        }

        for (Character character : stack) {
            if (character != '(' && character != ')') {
                output.append(character).append(" ");
            }
        }

        System.out.println(output);
    }
}