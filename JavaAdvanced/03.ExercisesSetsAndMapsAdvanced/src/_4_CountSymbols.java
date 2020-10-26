import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _4_CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Map<Character, Integer> symbols = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            symbols.putIfAbsent(currentChar, 0);
            symbols.put(currentChar, symbols.get(currentChar) + 1);
        }

        StringBuilder output = new StringBuilder();
        symbols.forEach((symbol, count) -> output.append(symbol).append(": ")
                .append(count).append(" time/s").append(System.lineSeparator()));

        System.out.println(output);
    }
}