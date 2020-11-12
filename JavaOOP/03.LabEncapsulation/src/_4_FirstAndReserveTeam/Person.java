package _4_FirstAndReserveTeam;

public class Person {
    private String firstName;
    private String lastName;
    private int	age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public void setFirstName(String firstName) {
        nameValidation(firstName, "First");
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        nameValidation(lastName, "Last");
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    private void nameValidation(String name, String messagePrefix) {
        if (name.length() < 3) {
            throw new IllegalArgumentException(messagePrefix + " name cannot be less than 3 symbols");
        }
    }

    public void setAge(int age) {
        validateAge(age);

        this.age = age;
    }

    public int getAge() {
        return age;
    }

    private void validateAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
    }

    private void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }

        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double bonus) {
        if (age <= 30) {
            bonus /= 2;
        }

        this.salary = this.salary * (1 + bonus / 100);
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.2f leva",
                firstName, lastName, salary);
    }
}
