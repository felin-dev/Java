import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class exercises {
    public static void main(String[] args) throws IOException {
        String path = "output.txt";
        File file = new File(path);

        PrintWriter writer = new PrintWriter(file);
        writer.println("Java Advanced");
        writer.close();
    }
}
