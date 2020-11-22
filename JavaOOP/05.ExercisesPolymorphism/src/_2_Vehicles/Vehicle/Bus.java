package _2_Vehicles.Vehicle;

import _2_Vehicles.Utilities.DecimalFormatter;

public class Bus extends Vehicle {

    private static final double FUEL_INCREASE_WITH_AIR_CONDITIONER_PER_KM = 1.4;

    public Bus(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm
                + FUEL_INCREASE_WITH_AIR_CONDITIONER_PER_KM, tankCapacity);
    }

    public String driveEmpty(double distance) {
        double fuelNeeded = distance * super.getFuelConsumptionPerKm()
                - FUEL_INCREASE_WITH_AIR_CONDITIONER_PER_KM;
        if (fuelNeeded > super.getFuelQuantity()) {
            throw new IllegalStateException(getClass().getSimpleName() + " needs refueling");
        }

        super.setFuelQuantity(super.getFuelQuantity() - fuelNeeded);
        return String.format("%s travelled %s km", getClass().getSimpleName(),
                DecimalFormatter.format(distance, "##.##"));
    }
}
