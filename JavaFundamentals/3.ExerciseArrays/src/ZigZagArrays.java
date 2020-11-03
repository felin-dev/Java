import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());
        boolean flag = true;
        int[] arrayOne = new int[number];
        int[] arrayTwo = new int[number];
        for (int i = 0; i < number; i++) {
            int[] currentArray = Arrays
                    .stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (flag) {
                arrayOne[i] = currentArray[0];
                arrayTwo[i] = currentArray[1];
                flag = false;
            } else {
                arrayOne[i] = currentArray[1];
                arrayTwo[i] = currentArray[0];
                flag = true;
            }
        }

        for (int current : arrayOne) {
            System.out.print(current + " ");
        }

        System.out.println();

        for (int current : arrayTwo) {
            System.out.print(current + " ");
        }
    }
}
