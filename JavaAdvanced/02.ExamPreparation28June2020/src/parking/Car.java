package parking;

public class Car {
    private String manufacturer;
    private String model;
    private int year;

    public Car(String manufacturer, String model, int year) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d)", this.manufacturer, this.model, this.year);
    }
    //Problem description
    //Your task is to create a repository, which stores items by creating the classes described below.
    //Car
    //First, write a Java class Car with the following fields:
    //•	manufacturer: String
    //•	model: String
    //•	year: int
    //The class constructor should receive manufacturer, model and year.
    // You need to create the appropriate getters and setters. Override the toString() method
    // in the following format:
    //"{manufacturer} {model} ({year})"
}
