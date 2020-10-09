import java.util.Scanner;

public class _3_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        char[][] first = readMatrix(sc, rows, cols);
        char[][] second = readMatrix(sc, rows, cols);

        char[][] output = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                output[row][col] =
                        first[row][col] == second[row][col]
                        ? first[row][col]
                        : '*';
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char symbol = output[row][col];
                if (col < cols - 1) {
                    System.out.print(symbol + " ");
                } else {
                    System.out.print(symbol);
                }
            }

            System.out.println();
        }
    }

    private static char[][] readMatrix(Scanner sc, int rows, int cols) {
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