package _2_Shapes;

public class Circle extends Shape {

    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
        super.setPerimeter(calculatePerimeter());
        super.setArea(calculateArea());
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    public Double calculatePerimeter() {
        if (super.getPerimeter() != null) {
            return super.getPerimeter();
        }

        super.setPerimeter(2 * Math.PI * radius);

        return super.getPerimeter();
    }

    @Override
    public Double calculateArea() {
        if (super.getArea() != null) {
            return super.getArea();
        }

        super.setArea(Math.PI * Math.sqrt(radius));

        return super.getArea();
    }
}
