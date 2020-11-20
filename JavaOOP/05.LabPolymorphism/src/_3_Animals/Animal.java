package _3_Animals;

public class Animal {
    private String name;
    private String favouriteFood;

    protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    protected String explainSelf() {
        return String.format("I am " + name + " and my favourite food is " + favouriteFood + "%n");
    }
}
