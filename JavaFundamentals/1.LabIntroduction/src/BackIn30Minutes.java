import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hour = Integer.parseInt(sc.nextLine());
        int minutes = Integer.parseInt(sc.nextLine());

        minutes += 30;
        if (minutes >= 60) {
            hour++;
        }

        minutes %= 60;

        if (hour >= 24) {
            hour = 0;
        }

        System.out.printf("%d:%02d", hour, minutes);
    }
}
