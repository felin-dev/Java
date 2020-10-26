package _4_RawData;

public class Cargo {
    private final int cargoWeight;
    private final String cargoType;

    public Cargo(int cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    public String getCargoType() {
        return this.cargoType;
    }
}