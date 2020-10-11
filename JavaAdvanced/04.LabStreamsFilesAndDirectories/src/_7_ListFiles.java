import java.io.File;

public class _7_ListFiles {
    public static void main(String[] args) {
        String path = "Files-and-Streams";
        File file = new File(path);
        File[] files = file.listFiles();
        assert files != null;
        for (File thisFile : files) {
            if (thisFile.isFile()) {
                System.out.printf("%s: [%s]%n", thisFile.getName(), thisFile.length());
            }
        }
    }
}