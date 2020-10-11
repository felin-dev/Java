import java.io.*;

public class Lab {
    public static void main(String[] args) {
        String path = "C:\\Java\\JavaAdvanced\\04.LabStreams,FilesAndDirectories\\input.txt";
        try (FileInputStream inputStream = new FileInputStream(path)) {
        int nextByte = inputStream.read();

            while (nextByte != -1) {
                System.out.print(Character.toChars(nextByte));
                nextByte = inputStream.read();
            }

            inputStream.close();
            example();
        } catch (IOException ex) {
            System.out.println();
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Done!");
        }
    }

    public static void example() throws IOException {
        throw new IOException("I am an exception in an empty method!");
    }
}