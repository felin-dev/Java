import java.util.Scanner;

public class ProjectsCreation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String architectName = sc.nextLine();
        int numberOfProjects = Integer.parseInt(sc.nextLine());
        int hoursNeeded = numberOfProjects * 3;
        System.out.println("The architect " + architectName + " will need " +
        hoursNeeded + " hours to complete " + numberOfProjects + " project/s.");
    }
}
