import java.io.FileInputStream;
import java.io.IOException;

public class _1_ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Java\\JavaAdvanced\\04.LabStreams,FilesAndDirectories\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        int nextByte = inputStream.read();

        while (nextByte != -1) {
            System.out.print(Integer.toBinaryString(nextByte) + " ");
            nextByte = inputStream.read();
        }

        inputStream.close();
    }
}