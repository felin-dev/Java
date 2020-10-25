import java.util.Arrays;
import java.util.Scanner;

public class _4_SumOf3x3InMatrix {
    public static int BEST_SUM;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] dimensions = sc.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = fillMatrix(sc, rows, cols);
        int[][] bestMatrix = findBestMatrix(matrix);
        System.out.println("Sum = " + BEST_SUM);
        printMatrix(bestMatrix);
    }

    private static void printMatrix(int[][] bestMatrix) {
        for (int[] matrixRow : bestMatrix) {
            for (int element : matrixRow) {
                System.out.print(element + " ");
            }

            System.out.println();
        }
    }

    private static int[][] findBestMatrix(int[][] matrix) {
        int[][] bestMatrix = new int[3][3];
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (currentSum > BEST_SUM) {
                    BEST_SUM = currentSum;
                    bestMatrix[0][0] = matrix[row][col];
                    bestMatrix[0][1] = matrix[row][col + 1];
                    bestMatrix[0][2] = matrix[row][col + 2];
                    bestMatrix[1][0] = matrix[row + 1][col];
                    bestMatrix[1][1] = matrix[row + 1][col + 1];
                    bestMatrix[1][2] = matrix[row + 1][col + 2];
                    bestMatrix[2][0] = matrix[row + 2][col];
                    bestMatrix[2][1] = matrix[row + 2][col + 1];
                    bestMatrix[2][2] = matrix[row + 2][col + 2];
                }
            }
        }

        return bestMatrix;
    }

    private static int[][] fillMatrix(Scanner sc, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return matrix;
    }
}