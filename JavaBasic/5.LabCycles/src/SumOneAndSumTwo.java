import java.util.Scanner;

public class SumOneAndSumTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int sumOne = 0;
        int sumTwo = 0;
        for (int i = 0; i < n; i++) {
            int y = Integer.parseInt(sc.nextLine());
            sumOne = sumOne + y;
        }
        for (int i = 0; i < n; i++) {
            int y = Integer.parseInt(sc.nextLine());
            sumTwo = sumTwo + y;
        }
        if (sumOne < sumTwo || sumTwo < sumOne) {
            int diff = sumOne - sumTwo;
            System.out.println("No, diff = " + Math.abs(diff));
        } else {
            System.out.println("Yes, sum = " + sumOne);
        }
    }
}
