import java.util.Scanner;

public class _1_FillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tasks = sc.nextLine().split(",\\s+");
        int size = Integer.parseInt(tasks[0]);
        String type = tasks[1];

        int[][] matrix = fillTheMatrix(size, type);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static int[][] fillTheMatrix(int size, String type) {
        int[][] matrix = new int[size][size];
        if (type.equals("A")) {
            for (int col = 0, currentNumber = 1; col < size; col++) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = currentNumber++;
                }
            }
        } else if (type.equals("B")) {
            for (int col = 0, currentNumber = 1; col < size; col++) {
                if (col % 2 == 0) {
                    for (int row = 0; row < size; row++) {
                        matrix[row][col] = currentNumber++;
                    }
                } else {
                    for (int row = size - 1; row >= 0; row--) {
                        matrix[row][col] = currentNumber++;
                    }
                }
            }
        }

        return matrix;
    }
}