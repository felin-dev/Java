package _6_Animals;

public class Animal {

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) throws Exception {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) throws Exception {
        if (!name.equals("")) {
            this.name = name;
        } else {
            throwException();
        }
    }

    public void setAge(int age) throws Exception {
        if (age >= 0) {
            this.age = age;
        } else {
            throwException();
        }
    }

    public void setGender(String gender) throws Exception {
        if (!gender.equals("") && (gender.equals("Male") || gender.equals("Female"))) {
            this.gender = gender;
        } else {
            throwException();
        }
    }

    private void throwException() throws Exception {
        throw new IllegalArgumentException("Invalid input!");
    }

    public String produceSound() {
        return "";
    }

    @Override
    public String toString() {

        String output = this.getClass().getSimpleName() + System.lineSeparator() +
                String.format("%s %d %s%n", name, age, gender) +
                this.produceSound();
        return output.trim();
    }
}
