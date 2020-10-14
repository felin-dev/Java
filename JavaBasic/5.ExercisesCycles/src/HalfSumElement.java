import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int numbers = Integer.parseInt(sc.nextLine());
            if (numbers > max) {
                max = numbers;
            }
            sum = sum + numbers;
        }

        sum = sum - max;
        if (sum == max) {
            System.out.printf("Yes%nSum = %d", max);
        } else {
            int diff = sum - max;
            System.out.printf("No%nDiff = %d", Math.abs(diff));
        }
    }
}
