import java.util.*;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<Character, Integer> digitsCount = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar != 32) {
                if (!digitsCount.containsKey(currentChar)) {
                    digitsCount.putIfAbsent(currentChar, 1);
                } else {
                    int count = digitsCount.get(currentChar);
                    digitsCount.put(currentChar, count + 1);
                }
            }
        }

        digitsCount
                .forEach((d, c)-> System.out.println(String.format("%s -> %d", d, c)));
    }
}
