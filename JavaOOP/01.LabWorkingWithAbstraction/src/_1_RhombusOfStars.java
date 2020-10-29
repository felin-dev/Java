import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1_RhombusOfStars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        printRhombus(n);
    }

    private static void printRhombus(int n) {
        printTopRhombus(n);
        printBottomRhombus(n);
    }

    private static void printBottomRhombus(int n) {
        for (int j = 1; j <= n; j++) {
            printElements(j, " ");
            printElements(n - j, "* ");
            System.out.println();
        }
    }

    private static void printTopRhombus(int n) {
        for (int i = 1; i <= n; i++) {
            printElements(n - i, " ");
            printElements(i, "* ");
            System.out.println();
        }
    }

    private static void printElements(int numberOfSpaces, String string) {
        for (int i = 0; i < numberOfSpaces; i++) {
            System.out.print(string);
        }
    }
}
