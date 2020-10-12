import java.util.ArrayDeque;
import java.util.Scanner;

public class _6_BalancedBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String brackets = sc.nextLine();
        ArrayDeque<Character> openBrackets = new ArrayDeque<>();

        boolean areBalanced = true;
        for (int i = 0; i < brackets.length(); i++) {
            char currentBracket = brackets.charAt(i);
            if (currentBracket == '{' || currentBracket == '[' || currentBracket == '(') {
                openBrackets.push(currentBracket);
            } else if (currentBracket == '}' || currentBracket == ']' || currentBracket == ')') {
                if (openBrackets.isEmpty()) {
                    areBalanced = false;
                    break;
                }

                char open = openBrackets.pop();
                if (currentBracket == '}' && open != '{') {
                    areBalanced = false;
                } else if (currentBracket == ']' && open != '[') {
                    areBalanced = false;
                } else if (currentBracket == ')' && open != '(') {
                    areBalanced = false;
                }
            }
        }

        System.out.println(areBalanced ? "YES" : "NO");
    }
}