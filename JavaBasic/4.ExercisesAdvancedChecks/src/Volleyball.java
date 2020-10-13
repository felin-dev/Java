import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String isLeap = sc.nextLine();
        int holidays = Integer.parseInt(sc.nextLine());
        double goingHome = Double.parseDouble(sc.nextLine());

        double availableDays = 48 - goingHome;
        availableDays = availableDays * 0.75;

        double gamesInSofia = holidays * 2.0 / 3;
        double daysPlayingVolleyball = availableDays + goingHome + gamesInSofia;

        if (isLeap.equals("leap")) {
            daysPlayingVolleyball = daysPlayingVolleyball * 1.15;
        }

        System.out.printf("%.0f", Math.floor(daysPlayingVolleyball));
    }
}
