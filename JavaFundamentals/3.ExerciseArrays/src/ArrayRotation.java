import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays
                .stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rotations = Integer.parseInt(sc.nextLine());
        while (rotations > 0) {
            int temp = 0;
            for (int i = 0; i < array.length; i++) {
                if (i == 0) {
                    temp = array[i];
                }
                if (i == array.length-1) {
                    array[i] = temp;
                } else {
                    array[i] = array[i+1];
                }
            }
            rotations--;
        }

        for (int arrayNumber : array) {
            System.out.print(arrayNumber + " ");
        }
    }
}
