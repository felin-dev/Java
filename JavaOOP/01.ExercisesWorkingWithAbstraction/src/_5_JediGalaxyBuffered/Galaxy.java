package _5_JediGalaxyBuffered;

public class Galaxy {

    private final int[][] galaxy;
    private int totalStarsCollected;

    public Galaxy(int rows, int cols) {
        this.galaxy = new int[rows][cols];
        this.totalStarsCollected = 0;

        int value = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                galaxy[row][col] = value++;
            }
        }
    }

    public void destroyStars(int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < galaxy.length && evilCol < galaxy[0].length) {
                galaxy[evilRow][evilCol] = 0;
            }

            evilRow--;
            evilCol--;
        }
    }

    public void collectStars(int jediRow, int jediCol) {
        while (jediRow >= 0 && jediCol < galaxy[1].length) {
            if (jediRow < galaxy.length && jediCol >= 0 && jediCol < galaxy[0].length) {
                totalStarsCollected += galaxy[jediRow][jediCol];
            }

            jediCol++;
            jediRow--;
        }
    }

    public int getTotalStarsCollected() {
        return totalStarsCollected;
    }
}
