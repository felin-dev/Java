import java.util.Arrays;
import java.util.Scanner;

public class _2_PositionOf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] matrixInfo = sc.nextLine().split("\\s+");
        int rows = Integer.parseInt(matrixInfo[0]);
        int cols = Integer.parseInt(matrixInfo[1]);

        int[][] matrix = new int[rows][cols];
        fillMatrix(sc, rows, matrix);

        boolean notFound = isNotFound(sc, matrix);

        if (notFound) {
            System.out.println("not found");
        }
    }

    private static void fillMatrix(Scanner sc, int rows, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private static boolean isNotFound(Scanner sc, int[][] matrix) {
        int number = Integer.parseInt(sc.nextLine());
        boolean notFound = true;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNumber = matrix[row][col];

                if (currentNumber == number) {
                    System.out.println(row + " " + col);
                    notFound = false;
                }
            }
        }
        return notFound;
    }
}