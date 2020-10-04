import java.io.File;
import java.util.Objects;

public class _8_GetFolderSize {
    public static void main(String[] args) {
        String path = "Exercises Resources";
        File folder = new File(path);
        long size = 0;
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            size += file.length();
        }

        System.out.println("Folder size: " + size);
    }
}