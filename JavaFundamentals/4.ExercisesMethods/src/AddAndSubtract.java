import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int first = Integer.parseInt(sc.nextLine());
        int second = Integer.parseInt(sc.nextLine());
        int third = Integer.parseInt(sc.nextLine());

        int result = result(first, second, third);
        System.out.println(result);
    }

    private static int result(int first, int second, int third) {
        int sum;
        sum = first + second;
        sum = subtract(sum, third);

        return sum;
    }

    private static int subtract(int sum, int third) {
        return sum - third;
    }
}
