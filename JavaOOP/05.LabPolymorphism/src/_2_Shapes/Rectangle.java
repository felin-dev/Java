package _2_Shapes;

public class Rectangle extends Shape {

    private final Double height;
    private final Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
        super.setPerimeter(calculatePerimeter());
        super.setArea(calculateArea());
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    public Double calculatePerimeter() {
        if (super.getPerimeter() != null) {
            return super.getPerimeter();
        }

        super.setPerimeter(2 * height + width);

        return super.getPerimeter();
    }

    @Override
    public Double calculateArea() {
        if (super.getArea() != null) {
            return super.getArea();
        }

        super.setArea(height * width);

        return super.getArea();
    }
}
