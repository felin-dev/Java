import java.util.ArrayList;
import java.util.Scanner;

public class _6_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String rotation = sc.nextLine();
        int angleRotation = Integer.parseInt(rotation.split("[(d+)]+")[1]) % 360;

        String input = sc.nextLine();
        ArrayList<String> linesForMatrix = new ArrayList<>();
        int maxLength = input.length();
        while (!input.equals("END")) {
            linesForMatrix.add(input);
            input = sc.nextLine();
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
        }

        int rows = linesForMatrix.size();
        int cols = maxLength;
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col < linesForMatrix.get(row).length()) {
                    matrix[row][col] = linesForMatrix.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }

        char[][] rotatedMatrix = getRotatedMatrix(matrix, rows, cols, angleRotation);

        printRotatedMatrix(rotatedMatrix);
    }

    private static void printRotatedMatrix(char[][] rotatedMatrix) {
        for (char[] row : rotatedMatrix) {
            for (char element : row) {
                System.out.print(element);
            }

            System.out.println();
        }
    }

    private static char[][] getRotatedMatrix(char[][] matrix, int rows, int cols, int angleRotation) {
        int rowsRotate;
        int colsRotate;
        if (angleRotation == 90) {
            rowsRotate = cols;
            colsRotate = rows;
            char[][] rotatedMatrix = new char[rowsRotate][colsRotate];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    int currentRowRotate = col;
                    int currentColRotate = (matrix.length - 1) - row;
                    rotatedMatrix[currentRowRotate][currentColRotate] = matrix[row][col];
                }
            }

            return rotatedMatrix;
        } else if (angleRotation == 180) {
            rowsRotate = rows;
            colsRotate = cols;
            char[][] rotatedMatrix = new char[rowsRotate][colsRotate];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    int currentRowRotate = (matrix.length - 1) - row;
                    int currentColRotate = (matrix[row].length - 1) - col;
                    rotatedMatrix[currentRowRotate][currentColRotate] = matrix[row][col];
                }
            }

            return rotatedMatrix;
        } else if (angleRotation == 270) {
            rowsRotate = cols;
            colsRotate = rows;
            char[][] rotatedMatrix = new char[rowsRotate][colsRotate];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    int currentRowRotate = (matrix[row].length - 1) - col;
                    int currentColRotate = row;
                    rotatedMatrix[currentRowRotate][currentColRotate] = matrix[row][col];
                }
            }

            return rotatedMatrix;
        }

        return matrix;
    }
}