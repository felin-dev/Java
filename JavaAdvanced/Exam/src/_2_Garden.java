import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2_Garden {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] size = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[size[0]][size[1]];

        fillTheMatrix(matrix);

        String input = reader.readLine();
        while (!input.equals("Bloom Bloom Plow")) {
            int[] coordinates = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            if (indexIsValid(coordinates, matrix)) {
                addFlowers(coordinates, matrix);
            } else {
                System.out.println("Invalid coordinates.");
            }

            input = reader.readLine();
        }

        printMatrix(matrix);
    }

    private static void addFlowers(int[] coordinates, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == coordinates[0] && col != coordinates[0]) {
                    matrix[row][col] = matrix[row][col] + 1;
                } else if (col == coordinates[1]) {
                    matrix[row][col] = matrix[row][col] + 1;
                }
            }
        }
    }

    private static boolean indexIsValid(int[] coordinates, int[][] matrix) {
        return coordinates[0] >= 0 && coordinates[0] < matrix.length
                && coordinates[1] >= 0 && coordinates[1] < matrix.length;
    }

    private static void printMatrix(int[][] matrix) {
        StringBuilder output = new StringBuilder();
        StringBuilder line = new StringBuilder();
        for (int[] row : matrix) {
            for (int space : row) {
                line.append(space).append(" ");
            }
            output.append(line.toString().trim());
            output.append(System.lineSeparator());
            line.setLength(0);
        }

        System.out.println(output.toString().trim());
    }

    private static void fillTheMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            Arrays.fill(row, 0);
        }
    }
}
