import java.util.Arrays;
import java.util.Scanner;

public class _3_DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        System.out.println(getDiagonalDifference(matrix));
    }

    private static int getDiagonalDifference(int[][] matrix) {
        int sumOne = 0;
        int sumTwo = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col) {
                    sumOne += matrix[row][col];
                }
            }
        }

        for (int row = matrix.length - 1; row >= 0; row--) {
            sumTwo += matrix[row][((matrix[row].length - 1) - row)];
        }

        return Math.abs(sumOne - sumTwo);
    }
}