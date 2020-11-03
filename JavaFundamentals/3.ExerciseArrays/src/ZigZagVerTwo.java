import java.util.Scanner;

public class ZigZagVerTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());
        String[] arrayOne = new String[number];
        String[] arrayTwo = new String[number];
        for (int i = 0; i < number; i++) {
            String[] currentArray = sc.nextLine().split(" ");
            if (i % 2 == 0) {
                arrayOne[i] = currentArray[0];
                arrayTwo[i] = currentArray[1];
            } else {
                arrayOne[i] = currentArray[1];
                arrayTwo[i] = currentArray[0];
            }
        }

        System.out.println(String.join(" ", arrayOne));
        System.out.println(String.join(" ", arrayTwo));
    }
}
