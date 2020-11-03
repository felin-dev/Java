package OddOccurrences;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().toLowerCase().split("\\s+");
        Map<String, Integer> wordsCount = new LinkedHashMap<>();
        for (String currentWord : words) {
            if (!wordsCount.containsKey(currentWord)) {
                wordsCount.put(currentWord, 1);
            } else {
                int currentCount = wordsCount.get(currentWord);
                currentCount = currentCount + 1;
                wordsCount.put(currentWord, currentCount);
            }
        }

        String oddWords = wordsCount
                .entrySet()
                .stream()
                .filter(w -> w.getValue() %2 == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", "));

        System.out.println(oddWords);
    }
}
