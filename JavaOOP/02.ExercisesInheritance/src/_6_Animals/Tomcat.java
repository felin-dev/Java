package _6_Animals;

public class Tomcat extends Cat {

    private static final String TOMCAT_GENDER = "Male";

    public Tomcat(String name, int age, String gender) throws Exception {
        super(name, age, TOMCAT_GENDER);
    }

    public Tomcat(String name, int age) throws Exception {
        super(name, age, TOMCAT_GENDER);
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}
