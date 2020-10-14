import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = Integer.parseInt(sc.nextLine());
        int end = Integer.parseInt(sc.nextLine());
        int magicNumber = Integer.parseInt(sc.nextLine());

        int counter = 0;
        boolean flag = false;
        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end; j++) {
                int result = i + j;
                counter++;
                if (result == magicNumber) {
                    System.out.printf("Combination N:%d (%d + %d = %d)",
                            counter, i, j, result);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        if (!flag) {
            System.out.printf("%d combinations - neither equals %d", counter, magicNumber);
        }
    }
}
