import java.util.Scanner;

public class AdvancedChecksClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter day of the week.");
        String day = sc.nextLine();

        switch (day) {
            case "Monday":
                System.out.println("Понеделник");
                break;
            case "Tuesday":
                System.out.println("Вторник");
                break;
            case "Wednesday":
                System.out.println("Сряда");
                break;
            case "Thursday":
                System.out.println("Четвъртък");
                break;
            case "Friday":
                System.out.println("Петък");
                break;
            case "Saturday":
                System.out.println("Събота");
                break;
            case "Sunday":
                System.out.println("Неделя");
                break;
            default:
                System.out.println("You have entered invalid day of the week!");
        }
    }
}
