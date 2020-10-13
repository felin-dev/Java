import java.util.Scanner;

public class AreaOfObjects {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String object = sc.nextLine();

        switch (object) {
            case "square": {
                double side = Double.parseDouble(sc.nextLine());
                double area = side * side;
                System.out.printf("%.3f", area);
                break;
            }
            case "rectangle": {
                double sideA = Double.parseDouble(sc.nextLine());
                double sideB = Double.parseDouble(sc.nextLine());
                double area = sideA * sideB;
                System.out.printf("%.3f", area);
                break;
            }
            case "circle": {
                double diameter = Double.parseDouble(sc.nextLine());
                double area = Math.PI * (diameter * diameter);
                System.out.printf("%.3f", area);
                break;
            }
            case "triangle": {
                double side = Double.parseDouble(sc.nextLine());
                double sideHeight = Double.parseDouble(sc.nextLine());
                double area = side * sideHeight / 2;
                System.out.printf("%.3f", area);
                break;
            }
            default:
                System.out.println("Wrong object type!");
                break;
        }
//        using if instead of switch
//        if (object.equals("square")) {
//            double side = Double.parseDouble(sc.nextLine());
//            double area = side * side;
//            System.out.printf("%.3f", area);
//        } else if (object.equals("rectangle")) {
//            double sideA = Double.parseDouble(sc.nextLine());
//            double sideB = Double.parseDouble(sc.nextLine());
//            double area = sideA * sideB;
//            System.out.printf("%.3f", area);
//        } else if (object.equals("circle")) {
//            double diameter = Double.parseDouble(sc.nextLine());
//            double area = Math.PI * (diameter * diameter);
//            System.out.printf("%.3f", area);
//        } else if (object.equals("triangle")) {
//            double side = Double.parseDouble(sc.nextLine());
//            double sideHeight = Double.parseDouble(sc.nextLine());
//            double area = side * sideHeight / 2;
//            System.out.printf("%.3f", area);
//        } else {
//            System.out.println("Wrong object type!");
//        }
    }
}
