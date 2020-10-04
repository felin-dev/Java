import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _1_SumLines {
    public static void main(String[] args) throws IOException {
        Path pathFile = Path.of("input.txt");
        List<String> lines = Files.readAllLines(pathFile);
        lines.stream().map(String::toCharArray).forEach
                (charArray -> {
                    int sum = 0;
                    for (char symbol : charArray) {
                        sum += symbol;
                    }

                    System.out.println(sum);
                });
    }
}