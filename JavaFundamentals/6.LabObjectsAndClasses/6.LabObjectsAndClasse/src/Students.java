import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        String input = sc.nextLine();
        while (!"end".equals(input)) {
            String[] currentStudent = input.split("\\s+");
            String firstName = currentStudent[0];
            String lastName = currentStudent[1];
            int age = Integer.parseInt(currentStudent[2]);
            String city = currentStudent[3];

            if (existingStudent(students, firstName, lastName)) {
                Student student = getStudent(students, firstName, lastName);

                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAge(age);
                student.setCity(city);
            } else {
                Student student = new Student(firstName, lastName, age, city);
                students.add(student);
            }

            input = sc.nextLine();
        }

        String city = sc.nextLine();

        for (Student student : students) {
            if (city.equals(student.getCity())) {
                System.out.printf("%s %s is %d years old%n",
                        student.getFirstName(), student.getLastName(),
                        student.getAge());
            }
        }
    }

    private static Student getStudent(List<Student> students, String firstName, String lastName) {
        Student existingStudent = null;

        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                existingStudent = student;
            }
        }

        return existingStudent;
    }

    private static boolean existingStudent(List<Student> students, String firstName, String lastName) {
        boolean existingStudent = false;
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                existingStudent = true;
                break;
            }
        }

        return existingStudent;
    }
}
