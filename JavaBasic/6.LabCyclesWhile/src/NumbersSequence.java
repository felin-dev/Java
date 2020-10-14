import java.util.Scanner;

public class NumbersSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());

        int currentNumber = 1;
        while (currentNumber <= number) {
            System.out.println(currentNumber);
            currentNumber = (currentNumber * 2) + 1;
        }
    }
}
