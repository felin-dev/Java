import java.util.Arrays;
        import java.util.Scanner;

public class ArrayToNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        while (numbers.length != 1) {
            int[] condense = new int[numbers.length-1];
            for (int i = 0; i < numbers.length - 1; i++) {
                condense[i] = numbers[i] + numbers[i +1];
            }
            numbers = condense.clone();
        }

        System.out.println(numbers[0]);
    }
}
