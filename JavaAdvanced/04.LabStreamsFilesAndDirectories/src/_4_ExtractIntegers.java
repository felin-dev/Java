import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class _4_ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Java\\JavaAdvanced\\04.LabStreams,FilesAndDirectories\\input.txt";
        Scanner sc = new Scanner(new FileInputStream(path));

        PrintWriter writer = new PrintWriter("extractIntegers.txt");

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                int number = sc.nextInt();
                writer.println(number);
            }
            sc.next();
        }

        sc.close();
        writer.close();
    }
}