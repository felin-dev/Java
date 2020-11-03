import java.util.Scanner;

public class ArrayRotationVerTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] array = sc.nextLine().split(" ");

        int rotations = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < rotations % array.length; i++) {
            String temp = array[0];
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = temp;
        }

        System.out.println(String.join(" ", array));
    }
}
