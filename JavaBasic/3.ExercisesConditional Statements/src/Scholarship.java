import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double income = Double.parseDouble(sc.nextLine());
        double averageGrades = Double.parseDouble(sc.nextLine());
        double minimalSalary = Double.parseDouble(sc.nextLine());

        double socialScholarship = 0;
        if (averageGrades >= 4.5 && income < minimalSalary) {
            socialScholarship = minimalSalary * 35 / 100;
        }

        double excellentScholarship = 0;
        if (averageGrades >= 5.5) {
            excellentScholarship = averageGrades * 25;
        }

        if (excellentScholarship == 0 && socialScholarship == 0) {
            System.out.println("You cannot get a scholarship!");
            return;
        }

        if (excellentScholarship >= socialScholarship) {
            System.out.printf("You get a scholarship for excellent results %.0f BGN%n", Math.floor(excellentScholarship));
            return;
        }

        System.out.printf("You get a Social scholarship %.0f BGN%n", Math.floor(socialScholarship));
    }
}
