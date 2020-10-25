
class GFG {
    static final int ROW = 3;
    static final int COL = 4;

    static void diagonalOrder(int[][] matrix) {

        // There will be ROW+COL-1 lines in the output
        for (int line = 1; line <= (ROW + COL - 1); line++) {

            // Get column index of the first element in this
            // line of output.The index is 0 for first ROW
            // lines and line - ROW for remaining lines
            int start_col = Math.max(0, line - ROW);

            // Get count of elements in this line. The count
            // of elements is equal to minimum of line number,
            // COL-start_col and ROW
            int count = Math.min(Math.min(line, (COL - start_col)), ROW);

            // Print elements of this line
            for (int j = 0; j < count; j++)
                System.out.print(matrix[Math.min(ROW, line) - j - 1]
                        [start_col + j] + " ");

            // Print elements of next diagonal on next line
            System.out.println();
        }
    }

    // Utility function to print a matrix
    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.print("\n");
        }
    }

    // Driver code
    public static void main(String[] args) {
        int[][] M = {
                {10, 11, 13, 16},     {12, 14, 17, 19},     {15, 18, 20, 21},
        };
        System.out.print("Given matrix is \n");
        printMatrix(M);

        System.out.print("\nDiagonal printing of matrix is \n");
        diagonalOrder(M);
    }
} 