package _9_CatLady;

public class Siamese implements Cat {
    private final String breed;
    private final String name;
    private final Double earSize;

    public Siamese(String name, Double earSize) {
        breed = "Siamese";
        this.name = name;
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f%n", this.breed, this.name, this.earSize);
    }
}
