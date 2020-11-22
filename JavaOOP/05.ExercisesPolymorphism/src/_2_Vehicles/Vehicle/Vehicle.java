package _2_Vehicles.Vehicle;

import _2_Vehicles.Utilities.DecimalFormatter;

public abstract class Vehicle {

    private double fuelQuantity;
    private final double fuelConsumptionPerKm;
    private final double tankCapacity;

    protected Vehicle (double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        this.tankCapacity = tankCapacity;
        setFuelQuantity(fuelQuantity);
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        validateFuel(fuelQuantity);

        this.fuelQuantity = fuelQuantity;
    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    protected double getFuelConsumptionPerKm() {
        return fuelConsumptionPerKm;
    }

    private void validateFuel(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        } else if (fuelQuantity > tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
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
        validateFuel(liters);
        double litersAfterRefueling = fuelQuantity + liters;
        try {
            validateFuel(litersAfterRefueling);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        fuelQuantity = litersAfterRefueling;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), fuelQuantity);
    }
}
