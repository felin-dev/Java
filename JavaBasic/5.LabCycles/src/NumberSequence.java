import java.util.Scanner;

public class NumberSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int first = Integer.parseInt(sc.nextLine());
        int min = first;
        int max = first;

        for (int i = 0; i < n - 1; i++) {
            int next = Integer.parseInt(sc.nextLine());
            if (next > max) {
                max = next;
            }
            if (next < min) {
                min = next;
            }
        }
        System.out.printf("Max number: %d%n", max);
        System.out.printf("Min number: %d%n", min);
    }
}
