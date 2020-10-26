package _7_Google;

public class Car {
    private final String model;
    private Integer power;

    public Car() {
        this.model = "";
    }

    public Car(String model, Integer power) {
        this.model = model;
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public Integer getPower() {
        return power;
    }
}
