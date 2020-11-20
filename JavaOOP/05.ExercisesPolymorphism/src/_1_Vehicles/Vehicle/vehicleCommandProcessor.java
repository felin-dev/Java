package _1_Vehicles.Vehicle;

import _1_Vehicles.Utilities.BufferedReader;

import java.util.LinkedHashMap;
import java.util.Map;

public class vehicleCommandProcessor {

    public static void processData() {

        Map<String, Vehicle> vehicles = fillVehicleMap();

        int numberOfVehicleCommands = Integer.parseInt(BufferedReader.readLine());
        while (numberOfVehicleCommands-- > 0) {
            processVehicleCommand(vehicles);
        }

        printVehiclesData(vehicles);
    }

    private static void printVehiclesData(Map<String, Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles.values()) {
            System.out.println(vehicle.toString());
        }
    }

    private static void processVehicleCommand(Map<String, Vehicle> vehicles) {
        String[] tokens = BufferedReader.readLine().split("\\s+");
        String command = tokens[0];
        switch (command) {
            case "Drive": {
                String vehicle = tokens[1];
                double distance = Double.parseDouble(tokens[2]);
                try {
                    System.out.println(vehicles.get(vehicle).drive(distance));
                } catch (IllegalStateException exception) {
                    System.out.println(exception.getMessage());
                }
                break;
            }
            case "Refuel": {
                String vehicle = tokens[1];
                double liters = Double.parseDouble(tokens[2]);
                vehicles.get(vehicle).refuel(liters);
                break;
            }
        }
    }

    private static Map<String, Vehicle> fillVehicleMap() {
        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        String[] tokens = BufferedReader.readLine().split("\\s+");
        vehicles.put(tokens[0], getNewVehicle(tokens));
        tokens = BufferedReader.readLine().split("\\s+");
        vehicles.put(tokens[0], getNewVehicle(tokens));

        return vehicles;
    }

    private static Vehicle getNewVehicle(String[] tokens) {
        switch (tokens[0]) {
            case "Car":
                return new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
            case "Truck":
                return new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
            default:
                throw new IllegalArgumentException("Unknown type of vehicle");
        }
    }
}
