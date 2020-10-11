import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class _2_RemovePunctuation {
    public static void main(String[] args) {
        String path = "C:\\Java\\JavaAdvanced\\04.LabStreams,FilesAndDirectories\\input.txt";
        try (FileInputStream inputStream = new FileInputStream(path)) {
            Scanner sc = new Scanner(inputStream);

            String table = ",.!?";
            FileOutputStream outputStream = new FileOutputStream("output.txt");
            while (sc.hasNext()) {
                String line = sc.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    char currentSymbol = line.charAt(i);
                    if (!table.contains(String.valueOf(currentSymbol))) {

                        outputStream.write(currentSymbol);
                    }
                }

                outputStream.write(new byte[] {'\r', '\n'});
            }

            inputStream.close();
            outputStream.close();
        } catch (IOException ex) {
            System.out.println("File not found!");
        }
    }
}