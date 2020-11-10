package _6_Animals;

public class Kitten extends Cat {

    private static final String KITTEN_GENDER = "Female";

    public Kitten(String name, int age, String gender) throws Exception {
        super(name, age, KITTEN_GENDER);
    }

    public Kitten(String name, int age) throws Exception {
        super(name, age, KITTEN_GENDER);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
