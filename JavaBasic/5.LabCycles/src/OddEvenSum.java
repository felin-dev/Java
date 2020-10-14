import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int sumOne = 0;
        int sumTwo = 0;
        for (int i = 0; i < n; i++) {
            int y = Integer.parseInt(sc.nextLine());
            if (i % 2 == 0) {
                sumOne = sumOne + y;
            } else {
                sumTwo = sumTwo + y;
            }
        }
        if (sumOne < sumTwo || sumTwo < sumOne) {
            int diff = sumOne - sumTwo;
            System.out.printf("No%nDiff = %d", Math.abs(diff));
        } else {
            System.out.printf("Yes%nSum = %d", sumOne);
        }
    }
}
