package _2_Shapes;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(2D, 4D);

        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());

        Shape circle = new Circle(13D);

        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
    }
}
