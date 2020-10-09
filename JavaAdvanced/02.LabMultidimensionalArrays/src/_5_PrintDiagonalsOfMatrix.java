import java.util.Arrays;
import java.util.Scanner;

public class _5_PrintDiagonalsOfMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int index = 0; index < size; index++) {
            System.out.print(matrix[index][index] + " ");
        }

        System.out.println();

        for (int index = 0; index < size; index++) {
            System.out.print(matrix[(size - 1) - index][index] + " ");
        }
    }
}