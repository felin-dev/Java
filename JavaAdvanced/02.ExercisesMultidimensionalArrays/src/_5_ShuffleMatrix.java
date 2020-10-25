import java.util.Scanner;

public class _5_ShuffleMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] dimensions = sc.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = getArray(sc, rows, cols);

        String command = sc.nextLine();
        while (!command.equals("END")) {
            String[] tasks = command.split("\\s+");
            String task = tasks[0];
            if (task.equals("swap") && tasks.length == 5) {
                int rowToChange = Integer.parseInt(tasks[1]);
                int colToChange = Integer.parseInt(tasks[2]);
                int rowToSwap = Integer.parseInt(tasks[3]);
                int colToSwap = Integer.parseInt(tasks[4]);
                if (rowToChange >= 0 && rowToChange < rows && colToChange >= 0
                        && colToChange < cols && rowToSwap >= 0 &&
                        rowToSwap < rows && colToSwap >= 0 && colToSwap < cols) {
                    String reserve = matrix[rowToChange][colToChange];
                    matrix[rowToChange][colToChange] = matrix[rowToSwap][colToSwap];
                    matrix[rowToSwap][colToSwap] = reserve;
                    printMatrix(matrix);
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }

            command = sc.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static String[][] getArray(Scanner sc, int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] currentRow = sc.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = currentRow[col];
            }
        }

        return matrix;
    }
}