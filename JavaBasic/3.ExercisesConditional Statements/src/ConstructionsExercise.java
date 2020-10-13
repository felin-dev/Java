import java.util.Scanner;

public class ConstructionsExercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());
//        boolean condition = number > 5;
//        System.out.println(condition);

        isFive(number);
    }

    private static void isFive(int number) {
        if (number > 5) {
            System.out.println("Number is greater than 5");
        } else if (number < 5) {
            System.out.println("The number is lower than 5");
        } else {
            System.out.println("The number is equal to 5");
        }
    }
}
