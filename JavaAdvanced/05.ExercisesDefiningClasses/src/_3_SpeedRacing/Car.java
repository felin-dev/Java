package _3_SpeedRacing;

public class Car {
    private final String model;
    private double fuel;
    private final double consumption;
    private int distance;

    public Car(String model, double fuel, double consumption) {
        this.model = model;
        this.fuel = fuel;
        this.consumption = consumption;
        this.distance = 0;
    }

    public boolean drive(int distanceToDrive) {
        double needFuel = distanceToDrive * this.consumption;
        if (needFuel <= this.fuel) {
            this.distance += distanceToDrive;
            this.fuel -= needFuel;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuel, this.distance);
    }
}