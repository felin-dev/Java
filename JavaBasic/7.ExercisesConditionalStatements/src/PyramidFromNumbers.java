import java.util.Scanner;

public class PyramidFromNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int currentNumber = 0;
        for (int row = 1; row <= n; row++) {
            boolean isReached = false;

            for (int col = 1; col <= row; col++) {

                System.out.print(++currentNumber + " ");

                if (currentNumber >= n) {
                    isReached = true;
                    break;
                }
            }

            System.out.println();

            if (isReached) {
                break;
            }
        }
    }
}
