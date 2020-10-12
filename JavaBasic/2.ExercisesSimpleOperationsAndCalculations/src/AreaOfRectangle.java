import java.util.Scanner;

public class AreaOfRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1 = Double.parseDouble(sc.nextLine());
        double y1 = Double.parseDouble(sc.nextLine());
        double x2 = Double.parseDouble(sc.nextLine());
        double y2 = Double.parseDouble(sc.nextLine());
        double length = Math.abs(x1 - x2);
        double width = Math.abs(y1 - y2);
        System.out.print("The length is: ");
        System.out.println(length);
        System.out.print("The width is: ");
        System.out.println(width);
        double area = length * width;
        System.out.print("The area is: ");
        System.out.printf("%.2f", area);
        System.out.println();
        double plain = 2 * (length + width);
        System.out.print("The plain is: ");
        System.out.printf("%.2f", plain);
        System.out.println();
    }
}
