import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String typeOfDay = sc.nextLine().toLowerCase();
        int age = Integer.parseInt(sc.nextLine());
        if ((age < 0) || (age > 122)) {
            System.out.println("Error!");
            return;
        }

        switch (typeOfDay) {
            case "weekday":
                if (age <= 18) {
                    System.out.println("12$");
                } else if (age <= 64) {
                    System.out.println("18$");
                } else {
                    System.out.println("12$");
                }
                break;
            case "weekend":
                if (age <= 18) {
                    System.out.println("15$");
                } else if (age <= 64) {
                    System.out.println("20$");
                } else {
                    System.out.println("15$");
                }
                break;
            case "holiday":
                if (age <= 18) {
                    System.out.println("5$");
                } else if (age <= 64) {
                    System.out.println("12$");
                } else {
                    System.out.println("10$");
                }
                break;
            default:
                System.out.println("Error!");
        }
    }
}