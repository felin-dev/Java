import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double grade = Double.parseDouble(sc.nextLine());

        getGrade(grade);
    }

    private static void getGrade(double grade) {
        String gradeName = "Fail";

        if (grade >= 3 && grade < 3.5) {
            gradeName = "Poor";
        } else if (grade >= 3.5 && grade < 4.5) {
            gradeName = "Good";
        } else if (grade >= 4.5 && grade < 5.5) {
            gradeName = "Very good";
        } else if (grade >= 5.5 && grade < 6) {
            gradeName = "Excellent";
        }

        System.out.println(gradeName);
    }
}
