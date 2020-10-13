import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        System.setIn(WorldSwimmingRecord.class.getResourceAsStream("/asdf.txt"));
        Scanner sc = new Scanner(System.in);

        double existingRecord = Double.parseDouble(sc.nextLine());
        double distanceMeters = Double.parseDouble(sc.nextLine());
        double secondsPerMeter = Double.parseDouble(sc.nextLine());

        double resistanceMeters = Math.floor(distanceMeters / 15);
        double resistance = resistanceMeters * 12.5;
        double newRecord = (distanceMeters * secondsPerMeter) + resistance;

        if (newRecord < existingRecord) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", newRecord);
        } else {
            double secondsNeededForRecord = newRecord - existingRecord;
            System.out.printf("No, he failed! He was %.2f seconds slower.", secondsNeededForRecord);
        }
    }
}
