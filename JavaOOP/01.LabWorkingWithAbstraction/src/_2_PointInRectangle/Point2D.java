package _2_PointInRectangle;

public class Point2D {
    private int x;
    private int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getPoint2D() {
        int[] point = new int[2];
        point[0] = x;
        point[1] = y;
        return point;
    }

    public boolean greaterOrEqual(Point2D point) {
        return point.y >= this.y && point.x >= this.x;
    }

    public boolean lowerOrEqual(Point2D point) {
        return point.y <= this.y && point.x <= this.x;
    }
}
