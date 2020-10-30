package _2_PointInRectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] rectangleCoordinates = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        Point2D bottomLeftPoint = new Point2D(rectangleCoordinates[0], rectangleCoordinates[1]);
        Point2D topRightPoint = new Point2D(rectangleCoordinates[2], rectangleCoordinates[3]);
        Rectangle rectangle = new Rectangle(bottomLeftPoint, topRightPoint);

        int count = Integer.parseInt(reader.readLine());
        while (count-- > 0) {
            int[] wantedPointInput = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            Point2D wantedPoint = new Point2D(wantedPointInput[0], wantedPointInput[1]);
            System.out.println(rectangle.containsPointInRectangle(wantedPoint));
        }
    }
}
