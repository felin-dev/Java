package _2_Vehicles;

import _2_Vehicles.Utilities.InputParser;
import _2_Vehicles.Vehicle.Bus;
import _2_Vehicles.Vehicle.Car;
import _2_Vehicles.Vehicle.Truck;
import _2_Vehicles.Vehicle.Vehicle;

import java.util.LinkedHashMap;
import java.util.Map;

public class VehicleCommandProcessor {

    private final InputParser inputParser;
    private final Map<String, Vehicle> vehicles;

    public VehicleCommandProcessor (InputParser inputParser) {
        this.inputParser = inputParser;
        this.vehicles = new LinkedHashMap<>();
    }

    public void processData() {
        vehicles.put("Car", createNewVehicle());
        vehicles.put("Truck", createNewVehicle());

        Bus bus = getNewBus(inputParser.parseSplitCommand("\\s+"));
        vehicles.put("Bus", bus);

        int numberOfVehicleCommands = Integer.parseInt(inputParser.parseCommand());
        while (numberOfVehicleCommands-- > 0) {
            processVehicleCommand(vehicles, bus);
        }
    }

    public void printVehiclesData() {
        for (Vehicle vehicle : vehicles.values()) {
            System.out.println(vehicle.toString());
        }
    }

    private void processVehicleCommand(Map<String, Vehicle> vehicles, Bus bus) {
        String[] tokens = inputParser.parseSplitCommand("\\s+");
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
            case "DriveEmpty": {
                double distance = Double.parseDouble(tokens[2]);
                try {
                    System.out.println(bus.driveEmpty(distance));
                } catch (IllegalStateException exception) {
                    System.out.println(exception.getMessage());
                }
                break;
            }
            case "Refuel": {
                String vehicle = tokens[1];

                double liters = Double.parseDouble(tokens[2]);
                try {
                    vehicles.get(vehicle).refuel(liters);
                } catch (IllegalArgumentException exception) {
                    System.out.println(exception.getMessage());
                }
                break;
            }

            default:
                throw new IllegalArgumentException("Unknown command for using vehicle.");
        }
    }

    private Vehicle createNewVehicle() {
        String[] tokens = inputParser.parseSplitCommand("\\s+");
        switch (tokens[0]) {
            case "Car":
                return new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),
                        Double.parseDouble(tokens[3]));
            case "Truck":
                return new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),
                        Double.parseDouble(tokens[3]));
            case "Bus":
                return getNewBus(tokens);

            default:
                throw new IllegalArgumentException("Unknown type of vehicle");
        }
    }

    private static Bus getNewBus(String[] tokens) {
        return new Bus(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),
                Double.parseDouble(tokens[3]));
    }
}
