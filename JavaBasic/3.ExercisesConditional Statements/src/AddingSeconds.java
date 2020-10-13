import java.util.Scanner;

public class AddingSeconds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstNumber = Integer.parseInt(sc.nextLine());
        int secondNumber = Integer.parseInt(sc.nextLine());
        int thirdNumber = Integer.parseInt(sc.nextLine());

        int totalSum = firstNumber + secondNumber + thirdNumber;
        int minutes = totalSum / 60;
        int seconds = totalSum % 60;

        System.out.printf("%d:%02d", minutes, seconds);
//        if (seconds < 10) {
//            System.out.printf("%d:0%d", minutes, seconds);
//        } else {
//            System.out.printf("%d:%d", minutes, seconds);
//        }
    }
}
