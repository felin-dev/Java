package classroom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Classroom {
    public int capacity;
    public List<Student> students;

    public Classroom(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        StringBuilder output = new StringBuilder();
        if (this.capacity > getStudentCount() && !this.students.contains(student)) {
            output.append(String.format("Added student %s %s",
                    student.getFirstName(), student.getLastName()));
            this.students.add(student);
        } else if (this.students.contains(student)) {
            output.append("Student is already in the classroom");
        } else if (this.capacity <= getStudentCount()){
            output.append("No seats in the classroom");
        }

        return output.toString().trim();
    }

    public String dismissStudent(Student student) {
        if (!this.students.contains(student)) {
            return "Student not found";
        } else {
            this.students.remove(student);
            return String.format("Removed student %s %s",
                    student.getFirstName(), student.getLastName());
        }
    }

    public String getSubjectInfo(String subject) {
        StringBuilder output = new StringBuilder();
        List<Student> currentRoom = new ArrayList<>();
        for (Student student : this.students) {
            if (student.getBestSubject().equals(subject)) {
                currentRoom.add(student);
            }
        }

        if (currentRoom.isEmpty()) {
            output.append("No students enrolled for the subject");
        } else {
            output.append(String.format("Subject: %s%n", subject));
            output.append(String.format("Students:%n"));
            for (Student student : currentRoom) {
                output.append(student.getFirstName())
                        .append(" ").append(student.getLastName())
                        .append(System.lineSeparator());
            }
        }

        return output.toString().trim();
    }

    public Student getStudent(String firstName, String lastName) {
        Student wantedStudent = null;
        for (Student student : this.students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                wantedStudent = student;
            }
        }

        return wantedStudent;
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Classroom size: %d%n", getStudentCount()));

        for (Student student : this.students) {
            output.append(String.format
                    ("==Student: First Name= %s, Last Name= %s, Best Subject= %s%n",
                            student.getFirstName(), student.getLastName(), student.getBestSubject()));
        }

        return output.toString().trim();
    }
}
