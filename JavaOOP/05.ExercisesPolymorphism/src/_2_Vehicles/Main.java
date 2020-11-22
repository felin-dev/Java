package _2_Vehicles;

import _2_Vehicles.Utilities.InputParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        InputParser inputParser = new InputParser(new BufferedReader(new InputStreamReader(System.in)));
        VehicleCommandProcessor vehicleCommandProcessor = new VehicleCommandProcessor(inputParser);

        vehicleCommandProcessor.processData();

        vehicleCommandProcessor.printVehiclesData();
    }
}
