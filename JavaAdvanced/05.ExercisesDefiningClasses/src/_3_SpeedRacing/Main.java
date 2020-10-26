package _3_SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            String[] tokens = sc.nextLine().split("\\s+");
            String model = tokens[0];
            int fuel = Integer.parseInt(tokens[1]);
            double consumption = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuel, consumption);
            cars.put(model, car);
        }

        String input = sc.nextLine();
        while (!input.equals("End")) {
            String model = input.split("\\s+")[1];
            int distanceToDrive = Integer.parseInt(input.split("\\s+")[2]);

            Car carToDrive = cars.get(model);
            if (!carToDrive.drive(distanceToDrive)) {
                System.out.println("Insufficient fuel for the drive");
            }

            input = sc.nextLine();
        }

        for (Car car : cars.values()) {
            System.out.println(car.toString());
        }
    }
}