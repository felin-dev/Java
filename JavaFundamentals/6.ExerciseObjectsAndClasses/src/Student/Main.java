package Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int studentsCount = Integer.parseInt(sc.nextLine());
        List<Student> students = new ArrayList<Student>();

        for (int i = 0; i < studentsCount; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            String name = tokens[0];
            String lastName = tokens[1];
            double grade = Double.parseDouble(tokens[2]);
            Student student = new Student(name, lastName, grade);
            students.add(student);
        }

        students
                .stream()
                .sorted((s1, s2) -> Double.compare(s2.getGrade(), s1.getGrade()))
                .forEach(student -> System.out.printf("%s %s: %.2f%n",
                        student.getName(), student.getLastName(), student.getGrade()));
    }
}
