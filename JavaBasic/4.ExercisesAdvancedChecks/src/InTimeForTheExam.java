import java.util.Scanner;

public class InTimeForTheExam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hourOfTheExam = Integer.parseInt(sc.nextLine());
        int minutesOfTheExam = Integer.parseInt(sc.nextLine());
        int hourOfArrival = Integer.parseInt(sc.nextLine());
        int minutesOfArrival = Integer.parseInt(sc.nextLine());

        int differenceInMinutes;
        int differenceInHours;
        int examTime;
        int arrivalTime;

        examTime = (hourOfTheExam * 60) + minutesOfTheExam;
        arrivalTime = (hourOfArrival * 60) + minutesOfArrival;

        if (examTime < arrivalTime) {
            System.out.println("Late");
            differenceInMinutes = arrivalTime - examTime;

            if (differenceInMinutes >= 60) {
                differenceInHours = differenceInMinutes / 60;
                differenceInMinutes = differenceInMinutes % 60;
                System.out.printf("%d:%02d hours after the start%n", differenceInHours, differenceInMinutes);
            } else {
                System.out.printf("%d minutes after the start%n", differenceInMinutes);
            }

        } else {
            differenceInMinutes = examTime - arrivalTime;

            if (differenceInMinutes >= 60) {
                System.out.println("Early");
                differenceInHours = differenceInMinutes / 60;
                differenceInMinutes = differenceInMinutes % 60;
                System.out.printf("%d:%02d hours before the start", differenceInHours, differenceInMinutes);
            } else if (differenceInMinutes <= 30) {
                System.out.println("On time");
                if (differenceInMinutes != 0) {
                    System.out.printf("%d minutes before the start%n", differenceInMinutes);
                }
            } else {
                System.out.println("Early");
                System.out.printf("%d minutes before the start%n", differenceInMinutes);
            }
        }
    }
}
