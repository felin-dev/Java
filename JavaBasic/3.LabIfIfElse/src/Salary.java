import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String currentDay = "Monday";
        double salary = 0.0;
        if (currentDay.equals("Monday")) {
            salary = Double.parseDouble(sc.nextLine());
        }
        System.out.println(salary);

    }
}
