import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfSnowballs = Integer.parseInt(sc.nextLine());
        double snowballValue = 0;
        int snowballSnowBest = 0;
        int snowballTimeBest = 0;
        int snowballQualityBest = 0;
        for (int i = 0; i < numberOfSnowballs; i++) {
            double snowballSnow = Double.parseDouble(sc.nextLine());
            int snowballTime = Integer.parseInt(sc.nextLine());
            int snowballQuality = Integer.parseInt(sc.nextLine());
            double currentSnowballValue = Math.pow((snowballSnow / snowballTime), (snowballQuality));
            if (currentSnowballValue > snowballValue) {
                snowballSnowBest = (int) snowballSnow;
                snowballTimeBest = snowballTime;
                snowballQualityBest = snowballQuality;
                snowballValue = currentSnowballValue;
            }
        }

        System.out.printf("%d : %d = %.0f (%d)", snowballSnowBest, snowballTimeBest, snowballValue, snowballQualityBest);
    }
}
