package _3_BirthdateCelebration;

public class Pet extends LivingBeing implements Birthable {

    private String name;
    private String birthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }
}
