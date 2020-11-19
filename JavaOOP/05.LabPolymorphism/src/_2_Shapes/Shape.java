package _2_Shapes;

public abstract class Shape {

    private Double perimeter;
    private Double area;

    protected Double getPerimeter() {
        return perimeter;
    }

    protected Double getArea() {
        return area;
    }

    public void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public abstract Double calculatePerimeter();

    public abstract Double calculateArea();
}
