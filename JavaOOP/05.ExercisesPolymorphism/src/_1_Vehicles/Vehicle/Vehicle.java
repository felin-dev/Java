package _1_Vehicles.Vehicle;

import _1_Vehicles.Utilities.DecimalFormatter;

public abstract class Vehicle {

    private double fuelQuantity;
    private final double fuelConsumptionPerKm;

    protected Vehicle (double fuelQuantity, double fuelConsumptionPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    public String drive(double distance) {

        double fuelNeeded = distance * fuelConsumptionPerKm;
        if (fuelNeeded > fuelQuantity) {
            throw new IllegalStateException(getClass().getSimpleName() + " needs refueling");
        }

        fuelQuantity -= fuelNeeded;
        return String.format("%s travelled %s km", getClass().getSimpleName(),
                DecimalFormatter.format(distance, "##.##"));
    }

    public void refuel(double liters) {
        fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), fuelQuantity);
    }
}
