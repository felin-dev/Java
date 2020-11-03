import java.util.Scanner;

public class PrintReverseOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(sc.nextLine());
        }
        for (int i = size - 1; i >= 0 ; i--) {
            System.out.print(numbers[i] + " ");
        }
    }
}
