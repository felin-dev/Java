package _5_CarSalesman;

public class Car {
    private final String model;
    private final String engineModel;
    private int weight;
    private String color;

    public Car(String model, String engineModel) {
        this.model = model;
        this.engineModel = engineModel;
        this.weight = -1;
        this.color = "n/a";
    }

    public Car(String model, String engineModel, int weight) {
        this(model, engineModel);
        this.weight = weight;
        this.color = "n/a";
    }

    public Car(String model, String engineModel, String color) {
        this(model, engineModel);
        this.weight = -1;
        this.color = color;
    }

    public Car(String model, String engineModel, int weight, String color) {
        this(model, engineModel, weight);
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }
}