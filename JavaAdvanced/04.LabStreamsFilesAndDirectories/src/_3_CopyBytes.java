import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _3_CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Java\\JavaAdvanced\\04.LabStreams,FilesAndDirectories\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("copyBytes.txt");
        int nextByte = inputStream.read();

        while (nextByte != -1) {
            if (nextByte == ' ' || nextByte == '\n') {
                outputStream.write(nextByte);
            } else {
                outputStream.write(String.valueOf(nextByte).getBytes());
            }

            nextByte = inputStream.read();
        }

        inputStream.close();
        outputStream.flush();
        outputStream.close();
    }
}
