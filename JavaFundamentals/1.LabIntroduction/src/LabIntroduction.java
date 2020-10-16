import java.util.Scanner;

public class LabIntroduction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        String ageString = sc.nextLine();
        String averageGradeString = sc.nextLine();

        int age = Integer.parseInt(ageString);
        double averageGrade = Double.parseDouble(averageGradeString);
        System.out.printf("Name: %s, Age: %d, Grade: %.2f", name, age, averageGrade);
    }
}
