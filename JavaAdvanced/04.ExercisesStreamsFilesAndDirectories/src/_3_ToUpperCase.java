import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _3_ToUpperCase {
    public static void main(String[] args) throws IOException {
        Path pathFile = Path.of("input.txt");
        List<String> lines = Files.readAllLines(pathFile);
        PrintWriter writer = new PrintWriter("outputUpper.txt");
        lines.forEach(line -> writer.println(line.toUpperCase()));
        writer.close();
    }
}