import java.util.Scanner;

public class GraduationPartTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        double avgGrade = 0.0;
        int gradeCount = 0;
        int badGradeCount = 0;

        while (gradeCount < 12) {
            double grade = Double.parseDouble(sc.nextLine());
            if (grade >= 4) {
                avgGrade += grade;
                gradeCount++;
                badGradeCount = 0;
            } else {
                badGradeCount++;
                if (badGradeCount > 1) {
                    break;
                }
            }
        }

        if (gradeCount == 12) {
            avgGrade = avgGrade / gradeCount;
            System.out.printf("%s graduated. Average grade: %.2f", name, avgGrade);
        } else {
            System.out.printf("%s has been excluded at %d grade", name, ++gradeCount);
        }
    }
}
