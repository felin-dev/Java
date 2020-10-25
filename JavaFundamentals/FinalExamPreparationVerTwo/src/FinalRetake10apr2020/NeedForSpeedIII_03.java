package FinalRetake10apr2020;

import java.util.*;

public class NeedForSpeedIII_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int carsToChooseFrom = Integer.parseInt(sc.nextLine());

        Map<String, List<Integer>> cars = new TreeMap<>();
        for (int i = 0; i < carsToChooseFrom; i++) {
            String[] carData = sc.nextLine().split("\\|");
            String car = carData[0];
            int mileage = Integer.parseInt(carData[1]);
            int fuel = Integer.parseInt(carData[2]);
            cars.putIfAbsent(car, new ArrayList<>());
            cars.get(car).add(mileage);
            cars.get(car).add(fuel);
        }

        String input = sc.nextLine();
        while (!"Stop".equals(input)) {
            String[] tokens = input.split(" : ");
            String command = tokens[0];
            switch (command) {
                case "Drive": {
                    String car = tokens[1];
                    int distance = Integer.parseInt(tokens[2]);
                    int fuelConsumed = Integer.parseInt(tokens[3]);
                    int currentFuel = cars.get(car).get(1);
                    int currentDistance = cars.get(car).get(0);
                    int fuelAfterRide = currentFuel - fuelConsumed;
                    int mileageAfterRide = currentDistance + distance;

                    if (currentFuel >= fuelConsumed) {
                        cars.get(car).set(0, mileageAfterRide);
                        cars.get(car).set(1, fuelAfterRide);
                        System.out.println(String.format("%s driven for %d kilometers. %d liters of fuel consumed.",
                                car, distance, fuelConsumed));
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    if (mileageAfterRide >= 100000) {
                        cars.remove(car);
                        System.out.println(String.format("Time to sell the %s!", car));
                    }
                }
                break;
                case "Refuel": {
                    String car = tokens[1];
                    int fuelRefilled = Integer.parseInt(tokens[2]);
                    int currentFuel = cars.get(car).get(1);
                    int fuelAfterRefill = currentFuel + fuelRefilled;
                    if (fuelAfterRefill > 75) {
                        fuelAfterRefill = 75;
                    }
                    int refilledFuel = fuelAfterRefill - currentFuel;
                    cars.get(car).set(1, fuelAfterRefill);
                    System.out.println(String.format("%s refueled with %d liters", car, refilledFuel));
                }
                break;
                case "Revert": {
                    String car = tokens[1];
                    int kilometers = Integer.parseInt(tokens[2]);
                    int currentMileage = cars.get(car).get(0);
                    int mileageAfterRevert = currentMileage - kilometers;
                    if (mileageAfterRevert >= 10000) {
                        cars.get(car).set(0, mileageAfterRevert);
                        System.out.println(String.format("%s mileage decreased by %d kilometers", car, kilometers));
                    } else {
                        cars.get(car).set(0, 10000);
                    }
                }
                break;
            }

            input = sc.nextLine();
        }

        cars
                .entrySet()
                .stream()
                .sorted((c1, c2) -> Integer.compare(c2.getValue().get(0), c1.getValue().get(0)))
                .forEach(c -> System.out.println(String.format("%s -> Mileage: %d kms, Fuel in the tank: %d lt.",
                        c.getKey(), c.getValue().get(0), c.getValue().get(1))));
    }
}