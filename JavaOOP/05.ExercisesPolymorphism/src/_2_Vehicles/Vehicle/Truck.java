package _2_Vehicles.Vehicle;

public class Truck extends Vehicle {

    private static final double FUEL_INCREASE_WITH_AIR_CONDITIONER_PER_KM = 1.6;
    private static final double FUEL_LEAK_PERCENTS = 5;

    public Truck(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm
                + FUEL_INCREASE_WITH_AIR_CONDITIONER_PER_KM, tankCapacity);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * (1 - (FUEL_LEAK_PERCENTS / 100)));
    }
}
