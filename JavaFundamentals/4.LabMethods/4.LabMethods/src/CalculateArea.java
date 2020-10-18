import java.util.Scanner;

public class CalculateArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int width = Integer.parseInt(sc.nextLine());
        int height = Integer.parseInt(sc.nextLine());

        int area = calculateArea(width, height);

        System.out.println(area);
    }

    private static int calculateArea(int a, int b) {
        return a * b;
    }
}
