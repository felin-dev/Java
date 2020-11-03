package VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        List<Truck> trucks = new ArrayList<>();
        int carsHorsepower = 0;
        int trucksHorsepower = 0;

        String input = sc.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            String model = tokens[1];
            String color = tokens[2];
            int horsepower = Integer.parseInt(tokens[3]);
            if ("car".equals(type)) {
                Car car = new Car(type, model, color, horsepower);
                carsHorsepower += car.getHorsepower();
                cars.add(car);
            } else if ("truck".equals(type)) {
                Truck truck = new Truck(type, model, color, horsepower);
                trucksHorsepower += truck.getHorsepower();
                trucks.add(truck);
            }

            input = sc.nextLine();
        }

        input = sc.nextLine();
        while (!"Close the Catalogue".equals(input)) {
            for (Car car : cars) {
                if (car.getModel().equals(input)) {
                    System.out.println(car);
                    break;
                }
            }

            for (Truck truck : trucks) {
                if (truck.getModel().equals(input)) {
                    System.out.println(truck);
                    break;
                }
            }

            input = sc.nextLine();
        }

        double averageCarHorsepower = 0;
        if (cars.size() != 0) {
            averageCarHorsepower = carsHorsepower * 1.0 / cars.size();
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", averageCarHorsepower);

        double averageTruckHorsepower = 0;
        if (trucks.size() != 0) {
            averageTruckHorsepower = trucksHorsepower * 1.0 / trucks.size();
        }
        System.out.printf("Trucks have average horsepower of: %.2f.", averageTruckHorsepower);
    }
}
