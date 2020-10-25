import java.util.Scanner;

public class _2_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] dimensions = sc.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = fillMatrix(rows, cols);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static String[][] fillMatrix(int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        StringBuilder currentPalindrome = new StringBuilder();
        char currentChar = 'a';
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                for (int i = 0; i < 3; i++) {
                    if (i == 1) {
                        currentPalindrome.append((char) ((currentChar) + col));
                    } else {
                        currentPalindrome.append(currentChar);
                    }
                }
                matrix[row][col] = currentPalindrome.toString();
                currentPalindrome.setLength(0);
            }

            currentChar++;
        }

        return matrix;
    }
}