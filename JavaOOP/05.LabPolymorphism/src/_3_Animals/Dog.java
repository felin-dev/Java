package _3_Animals;

public class Dog extends Animal {

    protected Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    protected String explainSelf() {
        return super.explainSelf() + "DJAAF";
    }
}
