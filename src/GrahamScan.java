import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wolf on 01/10/16.
 */
public class GrahamScan {
    private Stack convexHull = new Stack();

    private class Point implements Comparable {
        private int x, y;

        private int polarAngle(Point p) {
            return 0;
        }

        @Override
        public int compareTo(Object o) {
            Point second = (Point) o;
            return polarAngle(center) - second.polarAngle(center);
        }
    }

    private Point center;

    private Point[] points;

    public GrahamScan(Point[] p) {
        this.center = p[0];
        this.points = p;
        MergeSort.sort(points);//also should sort by y coordinate before p[0] should return the lowest y coordinate point
        for (Point point : points) {

        }
    }

    private boolean isCCW(Point p) {
        return false;
    }

}
