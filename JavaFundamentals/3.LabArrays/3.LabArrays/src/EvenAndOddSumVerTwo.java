import java.util.Arrays;
        import java.util.Scanner;

public class EvenAndOddSumVerTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int evenSum = 0;
        int oddSum = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenSum += number;
            } else {
                oddSum += number;
            }
        }

        System.out.println(evenSum - oddSum);
    }
}
