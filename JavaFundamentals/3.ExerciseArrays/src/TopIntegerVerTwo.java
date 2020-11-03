import java.util.Scanner;

public class TopIntegerVerTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        int[] numbers = new int[input.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = numbers[i];
            boolean isTopInteger = true;
            for (int j = i + 1; j < numbers.length; j++) {
                if (currentNumber <= numbers[j]) {
                    isTopInteger = false;
                    break;
                }
            }

            if (isTopInteger) {
                System.out.print(currentNumber + " ");
            }
        }
    }
}
