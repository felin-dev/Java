import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _7_MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        Path firstPath = Path.of("inputOne.txt");
        Path secondPath = Path.of("inputTwo.txt");

        List<String> linesFirst = Files.readAllLines(firstPath);
        List<String> linesSecond = Files.readAllLines(secondPath);

        PrintWriter writer = new PrintWriter("merge.txt");

        linesFirst.forEach(writer::println);
        linesSecond.forEach(writer::println);

        writer.close();
    }
}
