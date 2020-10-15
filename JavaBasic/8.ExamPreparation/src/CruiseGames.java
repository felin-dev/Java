import java.util.Scanner;

public class CruiseGames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String playerName = sc.nextLine();
        int gamesPlaid = Integer.parseInt(sc.nextLine());

        int volleyballCounter = 0;
        double volleyballPoints = 0.0;

        int tennisCounter = 0;
        double tennisPoints = 0.0;

        int badmintonCounter = 0;
        double badmintonPoints = 0.0;
        for (int games = 1; games <= gamesPlaid; games++) {
            String gameType = sc.nextLine();
            int points = Integer.parseInt(sc.nextLine());

            switch (gameType) {
                case "volleyball": {
                    volleyballPoints += points * 1.07;
                    volleyballCounter++;
                    break;
                }
                case "tennis": {
                    tennisPoints += points * 1.05;
                    tennisCounter++;

                    break;
                }
                case "badminton": {
                    badmintonPoints += points * 1.02;
                    badmintonCounter++;
                    break;
                }
            }
        }

        double volleyballAverage = volleyballPoints / volleyballCounter;
        double tennisAverage = tennisPoints / tennisCounter;
        double badmintonAverage = badmintonPoints / badmintonCounter;

        double gamesAverage = Math.floor(volleyballPoints + tennisPoints + badmintonPoints);

        if (volleyballAverage >= 75 && tennisAverage >= 75 && badmintonAverage >= 75) {
            System.out.printf("Congratulations, %s! You won the cruise games with %.0f points.", playerName, gamesAverage);
        } else {
            System.out.printf("Sorry, %s, you lost. Your points are only %.0f.", playerName, gamesAverage);
        }
    }
}

