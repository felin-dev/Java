import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int peopleCount = Integer.parseInt(sc.nextLine());
        int elevatorCapacity = Integer.parseInt(sc.nextLine());
        int elevatorCounter = 0;
        if (peopleCount % elevatorCapacity == 0) {
            int elevatorCycles = peopleCount / elevatorCapacity;
            System.out.println(elevatorCycles);
        } else {
            while (peopleCount > 0) {
                peopleCount -= elevatorCapacity;
                elevatorCounter++;

            }
        }

        if (elevatorCounter != 0) {
            System.out.println(elevatorCounter);
        }
    }
}
