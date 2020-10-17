import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        int[] numbers = new int[input.length];
        int magicSum = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int currentNumber = numbers[i];
                int nextNumber = numbers[j];
                int currentSum = currentNumber + nextNumber;
                if (currentSum == magicSum) {
                    System.out.print(currentNumber + " " + nextNumber + "\n");
                }
            }
        }
    }
}
