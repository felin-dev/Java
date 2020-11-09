package _4_NeedForSpeed;

public class Vehicle {

    final static double DEFAULT_FUEL_CONSUMPTION = 1.25;

    private double fuel;
    private int horsePower;
    private double fuelConsumption;

    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
        setFuelConsumption(1.25);
    }

    public static double getDefaultFuelConsumption() {
        return DEFAULT_FUEL_CONSUMPTION;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void drive(double kilometers) {
        double fuelNeededForTheTrip = kilometers * fuelConsumption;
        if (fuel >= fuelNeededForTheTrip) {
            fuel -= fuelNeededForTheTrip;
        }
    }
}
