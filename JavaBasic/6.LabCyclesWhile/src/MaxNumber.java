import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());

        int max = Integer.MIN_VALUE;

        int i = 0;
        while (i < number) {
            int currentNumber = Integer.parseInt(sc.nextLine());
            if (currentNumber > max) {
                max = currentNumber;
            }
            i++;
        }
        System.out.println(max);
    }
}
