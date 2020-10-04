import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _5_LineNumbers {
    public static int LINE_COUNTER = 1;
    public static void main(String[] args) throws IOException {
        Path pathFile = Path.of("inputLineNumbers.txt");
        List<String> lines = Files.readAllLines(pathFile);

        PrintWriter writer = new PrintWriter("lineNumbers.txt");
        lines.forEach(line -> {
            writer.print(LINE_COUNTER++ + ". ");
            writer.println(line);
        });

        writer.close();
    }
}