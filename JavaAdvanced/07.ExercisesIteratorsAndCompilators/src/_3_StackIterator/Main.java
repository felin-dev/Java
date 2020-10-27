package _3_StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();

        String command = reader.readLine();
        while (!command.equals("END")) {
            String[] tokens = command.split("[,\\s+]+");

            if (tokens[0].equals("Push")) {
                for (int i = 1; i < tokens.length; i++) {
                    stack.push(Integer.valueOf(tokens[i]));
                }
            } else {
                try {
                    stack.pop();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            command = reader.readLine();
        }

        for (int i = 0; i < 2; i++) {
            for (Integer integer : stack) {
                System.out.println(integer);
            }
        }
    }
}
