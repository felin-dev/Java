import java.util.Scanner;

public class Steps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int goal = 10000;
        int totalSteps = 0;
        while (!input.equals("Going home")) {
            int currentSteps = Integer.parseInt(input);
            totalSteps += currentSteps;
            if (totalSteps >= goal) {
                break;
            }

            input = sc.nextLine();
        }

        if (input.equals("Going home")) {
            int stepsToHome = Integer.parseInt(sc.nextLine());
            totalSteps += stepsToHome;
        }

        if (totalSteps >= goal) {
            System.out.println("Goal reached! Good job!");
        } else {
            int stepsLeft = goal - totalSteps;
            System.out.printf("%d more steps to reach goal.", stepsLeft);
        }
    }
}
