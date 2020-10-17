import java.util.Scanner;

public class TownInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String townName = sc.nextLine();
        int townPopulation = Integer.parseInt(sc.nextLine());
        int townArea = Integer.parseInt(sc.nextLine());

        System.out.printf("Town %s has population of %d and area %d square km.", townName, townPopulation, townArea);
    }
}
