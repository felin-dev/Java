import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double spaceshipWidth = Double.parseDouble(sc.nextLine());
        double spaceshipLength = Double.parseDouble(sc.nextLine());
        double spaceshipHeight = Double.parseDouble(sc.nextLine());
        double averageAstronautsHeight = Double.parseDouble(sc.nextLine());

        double spaceshipArea = spaceshipWidth * spaceshipLength * spaceshipHeight;
        double astronautsNeededSpace = (averageAstronautsHeight + 0.40) * 2 * 2;
        double astronautsOnBoard = Math.floor(spaceshipArea / astronautsNeededSpace);

        if (astronautsOnBoard > 3 && astronautsOnBoard < 10) {
            System.out.printf("The spacecraft holds %.0f astronauts.", astronautsOnBoard);
        } else if (astronautsOnBoard <= 3) {
            System.out.println("The spacecraft is too small.");
        } else {
            System.out.println("The spacecraft is too big.");
        }
    }
}
