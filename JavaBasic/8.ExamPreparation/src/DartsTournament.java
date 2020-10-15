import java.util.Scanner;

public class DartsTournament {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startingPoints = Integer.parseInt(sc.nextLine());

        int totalPoints = 0;
        int totalHits = 0;
        boolean wonWithBullseye = false;
        int pointsNeeded = startingPoints;
        while (pointsNeeded > 0) {
            String sectionHit = sc.nextLine();
            int pointsHit;
            int pointsHitTotal = 0;
            switch (sectionHit) {
                case "number section": {
                    pointsHit = Integer.parseInt(sc.nextLine());
                    totalPoints += pointsHit;
                    pointsHitTotal += pointsHit;
                    break;
                }
                case "double ring": {
                    pointsHit = Integer.parseInt(sc.nextLine());
                    totalPoints += pointsHit * 2;
                    pointsHitTotal += pointsHit * 2;
                    break;
                }
                case "triple ring": {
                    pointsHit = Integer.parseInt(sc.nextLine());
                    totalPoints += pointsHit * 3;
                    pointsHitTotal += pointsHit * 3;
                    break;
                }
                case "bullseye": {
                    wonWithBullseye = true;
                    break;
                }
                default: throw new IllegalArgumentException("Error!");
            }

            pointsNeeded -= pointsHitTotal;
            totalHits++;

            if (wonWithBullseye) break;
        }

        if (wonWithBullseye) {
            System.out.printf("Congratulations! You won the game with a bullseye in %d moves!", totalHits);
        } else if (pointsNeeded == 0) {
            System.out.printf("Congratulations! You won the game in %d moves!", totalHits);
        } else {
            int scoreDifference = Math.abs(startingPoints - totalPoints);
            System.out.printf("Sorry, you lost. Score difference: %d.", scoreDifference);
        }
    }
}