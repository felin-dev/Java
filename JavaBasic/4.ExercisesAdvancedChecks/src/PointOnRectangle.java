import java.util.Scanner;

public class PointOnRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x1 = Double.parseDouble(sc.nextLine());
        double y1 = Double.parseDouble(sc.nextLine());
        double x2 = Double.parseDouble(sc.nextLine());
        double y2 = Double.parseDouble(sc.nextLine());
        double x = Double.parseDouble(sc.nextLine());
        double y = Double.parseDouble(sc.nextLine());

        boolean firstCondition = false;
        boolean secondCondition = false;

        if (((x == x1) || (x == x2)) && ((y >= y1) && (y <= y2))) {
            firstCondition = true;
        }

        if (((y == y1) || (y == y2)) && ((x >= x1) && (x <= x2))) {
            secondCondition = true;
        }

        if (firstCondition || secondCondition) {
            System.out.println("Border");
        } else {
            System.out.println("Inside / Outside");
        }
    }
}
