import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (sb.charAt(sb.length() - 1) != currentChar) {
                sb.append(currentChar);
            }
        }

        System.out.println(sb.toString());
    }
}