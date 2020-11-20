package _1_Vehicles.Vehicle;

public class Car extends Vehicle {

    private static final double FUEL_INCREASE_WITH_AIR_CONDITIONER_PER_KM = 0.9;

    public Car(double fuelQuantity, double fuelConsumptionPerKm) {
        super(fuelQuantity, fuelConsumptionPerKm
                + FUEL_INCREASE_WITH_AIR_CONDITIONER_PER_KM);
    }
}
