import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _8_SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());
        Deque<Character> stack = new ArrayDeque<>();
        Deque<String> history = new ArrayDeque<>();
        while (count-- > 0) {
            String[] task = reader.readLine().split("\\s+");
            String command = task[0];
            switch (command) {
                case "1": {
                    String toAppend = task[1];
                    appendString(stack, toAppend, history);
                    break;
                }
                case "2": {
                    int toDelete = Integer.parseInt(task[1]);
                    deleteChars(stack, toDelete, history);
                    break;
                }
                case "3": {
                    int indexToPrint = Integer.parseInt(task[1]);
                    printIndex(stack, indexToPrint);
                    break;
                }
                case "4": {
                    undoLastOperation(stack, history);
                    break;
                }
            }
        }
    }

    private static void undoLastOperation(Deque<Character> stack, Deque<String> history) {
        stack.clear();
        if (history.size() > 0) {
            String historyString = history.pop();
            if (historyString.length() > 0) {
                for (int i = 0; i < historyString.length(); i++) {
                    char currentChar = historyString.charAt(i);
                    stack.push(currentChar);
                }
            }
        }
    }

    private static void deleteChars(Deque<Character> stack, int toDelete, Deque<String> history) {
        addInHistory(stack, history);

        if (toDelete > 0 && toDelete <= stack.size()){
            while (toDelete-- > 0) {
                stack.pop();
            }
        }
    }

    private static void appendString(Deque<Character> stack, String toAppend, Deque<String> history) {
        addInHistory(stack, history);

        for (int i = 0; i < toAppend.length(); i++) {
            char currentChar = toAppend.charAt(i);
            stack.push(currentChar);
        }

    }

    private static void addInHistory(Deque<Character> stack, Deque<String> history) {
        StringBuilder historyString = new StringBuilder();
        for (Character character : stack) {
            historyString.insert(0, character);
        }
        history.push(historyString.toString());
    }

    private static void printIndex(Deque<Character> stack, int indexToPrint) {
        Deque<Character> returnOriginalStack = new ArrayDeque<>();
        int size = stack.size();
        if (indexToPrint > 0 && indexToPrint <= size) {
            int popTimes = size - indexToPrint;
            while (popTimes-- > 0) {
                returnOriginalStack.push(stack.pop());
            }

            returnOriginalStack.push(stack.peek());
            System.out.println(stack.pop());

            while (returnOriginalStack.size() > 0) {
                stack.push(returnOriginalStack.pop());
            }
        }
    }
}