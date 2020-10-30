package _3_StudentSystem;

import java.util.Scanner;

public class StudentCommandsReceiver {
    public static void getTheStudentsCommands() {
        Scanner sc = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();

        String input = sc.nextLine();
        while (!input.equals("Exit")) {
            String[] tasks = input.split(" ");
            String command = tasks[0];
            switch (command) {
                case "Create": {
                    String name = tasks[1];
                    int age = Integer.parseInt(tasks[2]);
                    double grade = Double.parseDouble(tasks[3]);
                    Student student = new Student(name, age, grade);
                    studentSystem.addStudent(student);
                    break;
                }
                case "Show": {
                    String name = tasks[1];
                    System.out.println(studentSystem.studentInfo(name));
                    break;
                }
            }

            input = sc.nextLine();
        }
    }
}
