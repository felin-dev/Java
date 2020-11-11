package _2_SalaryIncrease;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int	age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        setSalary(calculateBonus(bonus));
    }

    private double calculateBonus(double bonus) {
        if (age <= 30) {
            bonus /= 2;
        }

        return salary * (1 + bonus / 100);
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("######.0#####");
        return getFirstName() + " " + getLastName() + " gets " + format.format(getSalary()) + " leva";
    }
}
