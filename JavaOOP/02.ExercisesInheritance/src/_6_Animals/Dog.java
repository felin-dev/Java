package _6_Animals;

public class Dog extends Animal {

    public Dog(String name, int age, String gender) throws Exception {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Woof!";
    }
}
