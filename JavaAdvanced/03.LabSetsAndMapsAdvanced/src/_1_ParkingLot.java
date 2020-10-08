import java.util.LinkedHashSet;
import java.util.Scanner;

public class _1_ParkingLot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] tasks = input.split(",\\s+");
            String direction = tasks[0];
            String carNumber = tasks[1];
            if (direction.equals("IN")) {
                parkingLot.add(carNumber);
            } else if (direction.equals("OUT")) {
                parkingLot.remove(carNumber);
            }

            input = sc.nextLine();
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String carNumber : parkingLot) {
                System.out.println(carNumber);
            }
        }
    }
}