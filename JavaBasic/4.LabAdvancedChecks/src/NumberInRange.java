import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());
        boolean isTrue = number >= -100 && number <= 100 && number != 0;

        if (isTrue) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
