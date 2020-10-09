import java.util.Arrays;
import java.util.Scanner;

public class _1_MatrixEqualsMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(sc);
        int[][] secondMatrix = readMatrix(sc);

        boolean areEqual = compareMatrices(firstMatrix, secondMatrix);

        System.out.println(areEqual ? "equal" : "not equal");
    }

    private static int[][] readMatrix(Scanner sc) {
        String[] matrixInfo = sc.nextLine().split("\\s+");
        int rows = Integer.parseInt(matrixInfo[0]);
        int cols = Integer.parseInt(matrixInfo[1]);

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays
                    .stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return matrix;
    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstArr = firstMatrix[row];
            int[] secondArr = secondMatrix[row];
            if (firstArr.length != secondArr.length) return false;

            for (int col = 0; col < firstArr.length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }
}