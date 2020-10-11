import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class _6_SortLines {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(path.toString()));
        List<String> lines = reader.lines().sorted().collect(Collectors.toList());
        PrintWriter writer = new PrintWriter("sortLines.txt");
        lines.forEach(writer::println);
        reader.close();
        writer.close();
    }
}