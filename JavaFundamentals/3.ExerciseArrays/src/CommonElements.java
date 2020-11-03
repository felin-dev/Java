import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arrayOne = sc.nextLine().split(" ");
        String[] arrayTwo = sc.nextLine().split(" ");

        for (String elementTwo : arrayTwo) {
            for (String elementOne : arrayOne) {
                if (elementTwo.equals(elementOne)) {
                    System.out.print(elementTwo + " ");
                }
            }
        }
    }
}
