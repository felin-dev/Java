import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class _6_WordCount {
    public static void main(String[] args) throws IOException {
        Path pathFile = Path.of("words.txt");
        List<String> lines = Files.readAllLines(pathFile);
        Map<String, Integer> wordsCount = new LinkedHashMap<>();

        for (String line : lines) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                wordsCount.putIfAbsent(word, 0);
            }
        }

        Path pathFileTwo = Path.of("text.txt");
        List<String> searchedLines = Files.readAllLines(pathFileTwo);
        for (String line : searchedLines) {
            Arrays.stream(line.split("\\.?,?\\s+"))
                    .forEach(word -> {
                        if (wordsCount.containsKey(word)) {
                            wordsCount.put(word, wordsCount.get(word) + 1);
                        }
                    });
        }

        PrintWriter writer = new PrintWriter("results.txt");
        wordsCount.forEach((word, count) -> writer.println(String.format("%s - %d", word, count)));

        writer.close();
    }
}