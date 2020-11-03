import java.util.concurrent.atomic.AtomicInteger;

public class StudentFirst {
    private static AtomicInteger nextId = new AtomicInteger(0);

    private final int id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String city;

    public StudentFirst(String firstName, String lastName, int age, String city) {
        this.id = nextId.getAndIncrement();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
    }

    public int getId() {
        return id;
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

    public String getCity() {
        return city;
    }
}
