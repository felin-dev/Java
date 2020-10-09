import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int number = Integer.parseInt(sc.nextLine());
        ArrayList<int[]> indexes = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNumber = matrix[row][col];

                if (currentNumber == number) {
                    indexes.add(new int[] {row, col});
                }
            }
        }

        if (indexes.isEmpty()) {
            System.out.println("not found");
        } else  {
            for (int[] index : indexes) {
                System.out.println(index[0] + " " + index[1]);
            }
        }
    }
}