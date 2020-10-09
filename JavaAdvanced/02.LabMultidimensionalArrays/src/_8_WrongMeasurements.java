import java.util.Arrays;
import java.util.Scanner;

public class _8_WrongMeasurements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());

        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();


        }
    }

    public static char[][] readMatrix(Scanner sc, int rows, int cols) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] symbols = sc.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = symbols[col].charAt(0);
            }
        }

        return matrix;
    }
}
