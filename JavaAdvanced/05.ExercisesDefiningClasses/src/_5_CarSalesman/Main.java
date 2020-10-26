package _5_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Engine> engines = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            Engine engine;
            String[] tasks = sc.nextLine().split("\\s+");
            String engineModel = tasks[0];
            int power = Integer.parseInt(tasks[1]);

            if (tasks.length == 2) {
                engine = new Engine(engineModel, power);
            } else if (tasks.length == 4) {
                int displacement = Integer.parseInt(tasks[2]);
                String efficiency = tasks[3];
                engine = new Engine(engineModel, power, displacement, efficiency);
            } else {
                try {
                    int displacement = Integer.parseInt(tasks[2]);
                    engine = new Engine(engineModel, power, displacement);
                } catch (NumberFormatException e) {
                    String efficiency = tasks[2];
                    engine = new Engine(engineModel, power, efficiency);
                }
            }

            engines.add(engine);
        }

        List<Car> cars = new ArrayList<>();
        int m = Integer.parseInt(sc.nextLine());
        while (m-- > 0) {
            Car car;
            String[] tasks = sc.nextLine().split("\\s+");
            String model = tasks[0];
            String engineModel = tasks[1];

            if (tasks.length == 2) {
                car = new Car(model, engineModel);
            } else if (tasks.length == 4) {
                int weight = Integer.parseInt(tasks[2]);
                String color = tasks[3];
                car = new Car(model, engineModel, weight, color);
            } else {
                try {
                    int weight = Integer.parseInt(tasks[2]);
                    car = new Car(model, engineModel, weight);
                } catch (NumberFormatException e) {
                    String color = tasks[2];
                    car = new Car(model, engineModel, color);
                }
            }

            cars.add(car);
        }

        StringBuilder output = new StringBuilder();
        for (Car car : cars) {
            output.append(String.format("%s:%n", car.getModel()));
            output.append(String.format("%s:%n", car.getEngineModel()));
            engines.forEach(engine -> {
                if (engine.getModel().equals(car.getEngineModel())) {
                    output.append(engine.toString());
                }
            });
            output.append("Weight: ");
            output.append(car.getWeight() != -1 ? car.getWeight() : "n/a");
            output.append(System.lineSeparator());
            output.append(String.format("Color: %s%n", car.getColor()));
        }

        System.out.println(output);
    }
}