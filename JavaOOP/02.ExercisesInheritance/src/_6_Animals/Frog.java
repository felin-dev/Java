package _6_Animals;

public class Frog extends Animal {

    public Frog(String name, int age, String gender) throws Exception {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Ribbit";
    }
}
