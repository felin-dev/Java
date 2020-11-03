import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        List<StudentFirst> students = new ArrayList<>();
        while (!line.equals("end")) {
            String[] parts = line.split("\\s+");
            String firstName = parts[0];
            String lastName = parts[1];
            int age = Integer.parseInt(parts[2]);
            String city = parts[3];

            StudentFirst student = new StudentFirst(firstName, lastName, age, city);

            students.add(student);
            line = sc.nextLine();
        }

        String city = sc.nextLine();

        for (StudentFirst student : students) {
            if (city.equals(student.getCity())) {
                System.out.printf("%s %s is %d years old, with student number %d%n",
                        student.getFirstName(), student.getLastName(),
                        student.getAge(), student.getId());
            }
        }
    }
}
