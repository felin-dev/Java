import java.util.Scanner;

public class GettingReadyForExam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int failThreshold = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();

        int failedTimes = 0;
        int gradeCount = 0;
        double totalGradeScore = 0;
        String lastProblem = "";
        while (!input.equals("Enough")) {
            int grade = Integer.parseInt(sc.nextLine());
            totalGradeScore += grade;
            gradeCount++;
            lastProblem = input;

            if (grade <= 4) {
                failedTimes++;
                if (failedTimes == failThreshold) {
                    break;
                }
            }
            input = sc.nextLine();
        }

        double averageGradeScore = totalGradeScore / gradeCount;
        if (input.equals("Enough")) {
            System.out.printf("Average score: %.2f%n" +
                    "Number of problems: %d%n" +
                    "Last problem: %s", averageGradeScore, gradeCount, lastProblem);
        } else {
            System.out.printf("You need a break, %d poor grades.", failedTimes);
        }
    }
}
