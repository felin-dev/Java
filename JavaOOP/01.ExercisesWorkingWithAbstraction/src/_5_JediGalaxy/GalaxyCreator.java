package _5_JediGalaxy;

public class GalaxyCreator {
    public int[][] getGalaxy(int[] dimensions) {
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] galaxy = new int[rows][cols];

        fillMatrix(rows, cols, galaxy);

        return galaxy;
    }

    private static void fillMatrix(int x, int y, int[][] matrix) {
        int value = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value++;
            }
        }
    }
}
