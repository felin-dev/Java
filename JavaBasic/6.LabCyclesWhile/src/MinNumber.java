import java.util.Scanner;

public class MinNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());

        int min = Integer.MAX_VALUE;

        int i = 0;
        while (i < number) {
            int currentNumber = Integer.parseInt(sc.nextLine());
            if (currentNumber < min) {
                min = currentNumber;
            }
            i++;
        }
        System.out.println(min);
    }
}
