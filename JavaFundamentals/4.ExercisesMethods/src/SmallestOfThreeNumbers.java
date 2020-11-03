import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int first = Integer.parseInt(sc.nextLine());
        int second = Integer.parseInt(sc.nextLine());
        int third = Integer.parseInt(sc.nextLine());

        int smallest = printSmallestOfThreeNumbers(first, second, third);
        System.out.println(smallest);
    }

    private static int printSmallestOfThreeNumbers(int first, int second, int third) {
        int smallest = first;
        if (second < first) {
            smallest = second;
        }

        if (third < second) {
            smallest = third;
        }

        return smallest;
    }
}
