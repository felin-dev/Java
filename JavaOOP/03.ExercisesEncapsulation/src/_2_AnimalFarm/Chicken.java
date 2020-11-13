package _2_AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        nameValidation(name);
        this.name = name;
    }

    private void nameValidation(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }

    private void setAge (int age) {
        ageValidation(age);
        this.age = age;
    }

    private void ageValidation(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        if (age >= 0 && age <= 5) {
            return 2;
        } else if (age > 5 && age <= 11) {
            return 1;
        } else {
            return 0.75;
        }
    }

    @Override
    public String toString() {
        return String.format("Chicken Mara (age %d) can produce %.2f eggs per day.",
                age, productPerDay());
    }
}
