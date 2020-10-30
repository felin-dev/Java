package _3_StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private final Map<String, Student> students;

    public StudentSystem() {
        this.students = new HashMap<>();
    }

    public Map<String, Student> getStudents() {
        return this.students;
    }

    public void addStudent(Student student) {
        this.students.putIfAbsent(student.getName(), student);
    }

    public String studentInfo(String name) {
        StringBuilder output = new StringBuilder();
        if (this.students.containsKey(name)) {
            Student student = students.get(name);
            output.append(String.format("%s is %s years old.", student.getName(), student.getAge()));

            if (student.getGrade() >= 5.00) {
                output.append(" Excellent student.");
            } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                output.append(" Average student.");
            } else {
                output.append(" Very nice person.");
            }
        }

        return output.toString().trim();
    }
}
