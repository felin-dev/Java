package _5_JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class ProcessGalaxyFromScanner {
    private static long totalStarsCollected;
    private final int[][] galaxy;
    private final Scanner sc = new Scanner(System.in);


    public ProcessGalaxyFromScanner() {
        this.galaxy = getGalaxy(sc);
    }

    public void processCommands() {
        String command = sc.nextLine();
        totalStarsCollected = 0;
        readCommands(sc, galaxy, command);
    }

    private static void readCommands(Scanner sc, int[][] galaxy, String command){
        while (!command.equals("Let the Force be with you")) {
            int[] jediIvoCoordinates = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilCoordinates = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];

            while (evilRow >= 0 && evilCol >= 0) {
                if (evilRow < galaxy.length && evilCol < galaxy[0].length) {
                    galaxy[evilRow][evilCol] = 0;
                }
                evilRow--;
                evilCol--;
            }

            int jediRow = jediIvoCoordinates[0];
            int jediCol = jediIvoCoordinates[1];

            while (jediRow >= 0 && jediCol < galaxy[1].length) {
                if (jediRow < galaxy.length && jediCol >= 0 && jediCol < galaxy[0].length) {
                    totalStarsCollected += galaxy[jediRow][jediCol];
                }

                jediCol++;
                jediRow--;
            }

            command = sc.nextLine();
        }
    }


    private static int[][] getGalaxy(Scanner sc) {
        GalaxyCreator galaxyCreator = new GalaxyCreator();

        int[] dimensions = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        return galaxyCreator.getGalaxy(dimensions);
    }

    public static void printTotalStarsCollected() {
        System.out.println(totalStarsCollected);
    }

    @Override
    public String toString() {
        return String.format("%o", totalStarsCollected);
    }
}
