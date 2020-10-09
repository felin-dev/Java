import java.util.Arrays;
import java.util.Scanner;

public class _4_SumMatrixElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] matrixInfo = sc.nextLine().split(",\\s+");
        int rows = Integer.parseInt(matrixInfo[0]);
        int cols = Integer.parseInt(matrixInfo[1]);

        int[][] matrix = fillMatrix(sc, rows, cols);
        System.out.println(rows);
        System.out.println(cols);
        sum(matrix);
    }

    private static void sum(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNumber = matrix[row][col];
                sum+=currentNumber;
            }
        }

        System.out.println(sum);
    }

    private static int[][] fillMatrix(Scanner sc, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays
                    .stream(sc.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return matrix;
    }
}