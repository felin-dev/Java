import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class _5_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader("input.txt"));

        List<String> lines = reader.lines().collect(Collectors.toList());
        PrintWriter writer = new PrintWriter("linesDividableByThree.txt");
        for (int i = 0; i < lines.size(); i++) {
            if ((i + 1) % 3 == 0) {
                writer.println(lines.get(i));
            }
        }

        reader.close();
        writer.close();
    }
}