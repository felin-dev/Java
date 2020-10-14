import java.util.Scanner;

public class Graduating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        double avgGrade = 0.0;
        int gradeCount = 0;

        while (gradeCount < 12) {
            double grade = Double.parseDouble(sc.nextLine());
            if (grade >= 4) {
                avgGrade += grade;
                gradeCount++;
            }
        }
        avgGrade = avgGrade / gradeCount;
        System.out.printf("%s graduated. Average grade: %.2f", name, avgGrade);
    }
}
