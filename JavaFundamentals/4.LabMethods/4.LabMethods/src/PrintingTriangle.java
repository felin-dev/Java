import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxLineNumber = Integer.parseInt(sc.nextLine());

        getPrintTriangle(maxLineNumber);
    }

    private static void getPrintTriangle(int maxLineNumber) {
        printTopHalf(maxLineNumber);
        printBottomHalf(maxLineNumber - 1);
    }

    private static void printTopHalf(int numberOfRows) {
        for (int i = 1; i <= numberOfRows; i++) {
            printRow(1, i);
            System.out.println();
        }
    }

    private static void printBottomHalf(int longestLine) {
        for (int i = longestLine; i >= 1; i--) {
            printRow(1, i);
            System.out.println();
        }
    }

    private static void printRow(int from, int to) {
        for (int j = from; j <= to; j++) {
            System.out.print(j + " ");
        }
    }
}
