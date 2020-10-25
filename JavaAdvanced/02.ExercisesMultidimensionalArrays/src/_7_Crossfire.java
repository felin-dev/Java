import java.util.*;
import java.util.stream.Collectors;

public class _7_Crossfire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] dimensions = sc.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        List<List<Integer>> crossField = fillArray(rows, cols);
        String input = sc.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            String[] tasks = input.split("\\s+");
            int rowCoordinate = Integer.parseInt(tasks[0]);
            int colCoordinate = Integer.parseInt(tasks[1]);
            int damage = Integer.parseInt(tasks[2]);

            for (int i = Math.max(0, rowCoordinate - damage);
                 i < Math.min(rowCoordinate + damage + 1, crossField.size()); i++) {
                List<Integer> row = crossField.get(i);
                if (i != rowCoordinate && colCoordinate >= 0 && colCoordinate < row.size()) {
                    row.remove(colCoordinate);
                }
            }

            if (rowCoordinate >= 0 && rowCoordinate < crossField.size()) {
                List<Integer> newRow = getNewRow(crossField.get(rowCoordinate), colCoordinate, damage);
                if (newRow.isEmpty()) {
                    crossField.remove(rowCoordinate);
                } else {
                    crossField.set(rowCoordinate, newRow);
                }
            }

            input = sc.nextLine();
        }

        for (List<Integer> row : crossField) {
            String output = row.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(" "));
            System.out.println(output);
        }
    }

    private static List<Integer> getNewRow(List<Integer> row, int colCoordinate, int damage) {
        List<Integer> newRow = new ArrayList<>();
        int fromIndex = colCoordinate - damage;
        int toIndex = colCoordinate + damage + 1;
        for (int i = 0; i < Math.max(0, Math.min(fromIndex, row.size())); i++) {
            newRow.add(row.get(i));
        }

        for (int i = Math.min(Math.max(0, toIndex), row.size()); i < row.size(); i++) {
            newRow.add(row.get(i));
        }

        return newRow;
    }

    private static List<List<Integer>> fillArray(int rows, int cols) {
        List<List<Integer>> matrix = new ArrayList<>();
        int currentBox = 1;
        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(currentBox++);
            }

            matrix.add(row);
        }

        return matrix;
    }
}