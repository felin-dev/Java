import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class _2_SumBytes {
    public static void main(String[] args) throws IOException {
        Path pathFile = Path.of("input.txt");

        long sum = 0L;
        byte[] values = Files.readAllBytes(pathFile);
        for(byte value : values) {
            if (value != 10 && value != 13) {
                sum += value;
            }
        }

        System.out.println(sum);
    }
}
