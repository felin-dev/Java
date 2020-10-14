import java.util.Scanner;

public class Trial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());
        int number2 = Integer.parseInt(sc.nextLine());

        if (number % number2 == 0) {
            System.out.println("Works");
        } else {
            System.out.println("Error");
        }
    }
}
