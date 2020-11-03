import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays
                .stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (i < array.length-1) {
                if (array[i] > array[i+1]) {
                    counter++;
                }
            } else {
                counter++;
            }
        }

        int[] strongArray = new int[counter];
        int countStrong = 0;
        for (int i = 0; i < array.length; i++) {
            if (i < array.length-1) {
                if (array[i] > array[i+1]) {
                    strongArray[countStrong] = array[i];
                    countStrong++;
                }
            } else {
                strongArray[countStrong] = array[i];
            }
        }

        for (int strongNumber : strongArray) {
            System.out.print(strongNumber + " ");
        }
    }
}
