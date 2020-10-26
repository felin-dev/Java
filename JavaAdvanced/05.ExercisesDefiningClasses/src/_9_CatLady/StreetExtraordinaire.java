package _9_CatLady;

public class StreetExtraordinaire implements Cat {
    private final String breed;
    private final String name;
    private final Double decibelsOfMeows;

    public StreetExtraordinaire(String name, Double decibelsOfMeows) {
        breed = "StreetExtraordinaire";
        this.name = name;
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f%n", this.breed, this.name, this.decibelsOfMeows);
    }
}
