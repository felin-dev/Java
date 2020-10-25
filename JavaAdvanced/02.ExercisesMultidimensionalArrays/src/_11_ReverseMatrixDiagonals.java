import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _11_ReverseMatrixDiagonals {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Integer> currentRow = Arrays.stream(reader.readLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            matrix.add(currentRow);
        }

        matrix = rotateMatrix(matrix);

        diagonalOrder(matrix, rows, cols);
    }

    private static List<List<Integer>> rotateMatrix(List<List<Integer>> matrix) {
        List<List<Integer>> rotated = new ArrayList<>();
        for (int i = matrix.size() - 1; i >= 0; i--) {
            List<Integer> currentRow = new ArrayList<>();
            for (int j = matrix.get(i).size() - 1; j >= 0; j--) {
                currentRow.add(matrix.get(i).get(j));
            }

            rotated.add(currentRow);
        }

        return rotated;
    }

    static void diagonalOrder(List<List<Integer>> matrix, int rows, int cols) {
        StringBuilder output = new StringBuilder();
        for (int line = 1; line <= (rows + cols - 1); line++) {
            int start_col = Math.max(0, line - rows);
            int count = Math.min(Math.min(line, (cols - start_col)), rows);

            List<Integer> rotation = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                rotation.add(matrix.get(Math.min(rows, line) - j - 1)
                        .get(start_col + j));
            }

            for (int i = rotation.size() - 1; i >= 0; i--) {
                output.append(String.format("%d ", rotation.get(i)));
            }

            output.append(System.lineSeparator());
        }

        System.out.println(output);
    }
}