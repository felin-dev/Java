import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int y = Integer.parseInt(sc.nextLine());
            sum += y;
        }
        System.out.println(sum);
    }
}
