import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class _8_NestedFolders {
    public static void main(String[] args) {
        String path = "Files-and-Streams";
        File file = new File(path);
        Deque<File> deque = new ArrayDeque<>();

        deque.offer(file);
        int count = 0;
        while (!deque.isEmpty()) {
            count++;
            File f = deque.poll();
            System.out.println(f.getName());
            File[] files = f.listFiles();
            assert files != null;
            for (File innerFile : files) {
                if (innerFile.isDirectory()) {
                    deque.offer(innerFile);
                }
            }
        }

        System.out.printf("%d folders", count);
    }
}