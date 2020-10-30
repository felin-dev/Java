package _2_PointInRectangle;

public class Rectangle {
    private final Point2D bottomLeftPoint;
    private final Point2D topRightPoint;

    public Rectangle(Point2D bottomLeftPoint, Point2D topRightPoint) {
        this.bottomLeftPoint = bottomLeftPoint;
        this.topRightPoint = topRightPoint;
    }

    public boolean containsPointInRectangle(Point2D wantedPoint) {
        return this.bottomLeftPoint.greaterOrEqual(wantedPoint)
                && topRightPoint.lowerOrEqual(wantedPoint);
    }
}
