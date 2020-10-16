import java.util.Scanner;

public class Passed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String gradeString = sc.nextLine();

        double grade = Double.parseDouble(gradeString);
        if (grade >= 3.00) {
            System.out.println("Passed!");
        }
    }
}
