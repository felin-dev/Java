import java.util.Scanner;

public class BooleanExercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());
        boolean condition = number == 5;
        System.out.println(condition);

        int number2 = Integer.parseInt(sc.nextLine());
        boolean condition2 = number2 != 5;
        System.out.println(condition2);

        int number3 = Integer.parseInt(sc.nextLine());
        boolean condition3 = number3 >= 5;
        System.out.println(condition3);
    }
}
