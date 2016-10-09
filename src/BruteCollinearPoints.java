import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wolf on 09/10/16.
 */
public class BruteCollinearPoints {
    private LineSegment[] lineSegments;

    public BruteCollinearPoints(Point[] points) {
        Arrays.sort(points);
        List<LineSegment> segments = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int k = i + 1; k < points.length; k++) {
                for (int j = k + 1; j < points.length; j++) {
                    for (int t = j + 1; t < points.length; t++) {
                        if (points[i].slopeTo(points[k]) == points[i].slopeTo(points[j]) &&
                                points[i].slopeTo(points[k]) == points[i].slopeTo(points[t])) {
                            segments.add(new LineSegment(points[i], points[t]));
                        }
                    }
                }
            }
        }
        lineSegments = segments.toArray(lineSegments);
    }

    public int numberOfSegments() {
        return lineSegments.length;
    }

    public LineSegment[] segments() {
        return lineSegments;
    }
}