import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int trainers = Integer.parseInt(sc.nextLine());

        String presentation = sc.nextLine();

        double averageGrades = 0;
        double totalAverage = 0;
        int numberOfPresentation = 0;
        while (!presentation.equals("Finish")) {
            for (int i = 1; i <= trainers; i++) {
                double grade = Double.parseDouble(sc.nextLine());
                averageGrades += grade;
                if (i == trainers) {
                    averageGrades /= trainers;
                    totalAverage += averageGrades;
                    System.out.printf("%s - %.2f.%n", presentation, averageGrades);
                    numberOfPresentation++;
                }
            }
            presentation = sc.nextLine();
            averageGrades = 0;
        }
        totalAverage /= numberOfPresentation;
        System.out.printf("Student's final assessment is %.2f.", totalAverage);
    }
}
