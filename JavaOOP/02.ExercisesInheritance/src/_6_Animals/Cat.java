package _6_Animals;

public class Cat extends Animal {

    public Cat(String name, int age, String gender) throws Exception {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Meow meow";
    }
}
