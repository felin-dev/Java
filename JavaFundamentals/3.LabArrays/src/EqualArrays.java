import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arrayOne = Arrays
                .stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] arrayTwo = Arrays
                .stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean flag = true;
        int arrayOneSum = 0;
        int placeOfCrash = 0;
        if (arrayOne.length == arrayTwo.length) {
            for (int i = 0; i < arrayOne.length; i++) {
                if (arrayOne[i] == arrayTwo[i]) {
                    arrayOneSum += arrayOne[i];
                } else {
                    placeOfCrash = i;
                    flag = false;
                    break;
                }
            }
        } else {
            flag = false;
            System.out.println("Error!");
        }

        if (flag) {
            System.out.printf("Arrays are identical. Sum: %d", arrayOneSum);
        } else {
            System.out.printf("Arrays are not identical. " +
                    "Found difference at %d index.", placeOfCrash);
        }
    }
}
