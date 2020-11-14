package _1_CarShop;

public class Seat implements Car {
    private final String model;
    private final String color;
    private final Integer horsePower;
    private final String country;

    public Seat(String model, String color, Integer horsePower, String country) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.country = country;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Integer getHorsePower() {
        return horsePower;
    }

    @Override
    public String countryProduced() {
        return country;
    }

    @Override
    public String toString() {
        return "This is " + model + " produced in " + country + " and have " + TIRES + " tires";
    }
}
