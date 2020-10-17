import java.util.Scanner;

public class DayOfTheWeek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dayOfTheWeek = Integer.parseInt(sc.nextLine());

        String[] daysOfTheWeek = {"Monday", "Tuesday", "Wednesday", "Thursday",
                "Friday", "Saturday", "Sunday"
        };

        if (dayOfTheWeek >= 1 && dayOfTheWeek <= 7) {
            System.out.println(daysOfTheWeek[dayOfTheWeek - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
