package _9_CatLady;

public class Cymric implements Cat {
    private final String breed;
    private final String name;
    private final Double furLength;

    public Cymric(String name, Double furLength) {
        breed = "Cymric";
        this.name = name;
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f%n", this.breed, this.name, this.furLength);
    }
}
