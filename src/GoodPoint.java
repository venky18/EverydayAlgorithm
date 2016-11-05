import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoodPoint {
    private static class Point {
        public double x;
        public double y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double getDistance(Point p) {
            return Math.sqrt((p.x - this.x) * (p.x - this.x) + (p.y - this.y) * (p.y - this.y));
        }
    }

    private interface ShapeMembershipCheckable {
        boolean checkInside(Point p);
    }

    private static class Polygon implements ShapeMembershipCheckable {
        private List<Point> vertices;
        public Polygon(List<Point> vertices) {
            this.vertices = vertices;
        }

        public boolean checkInside(Point p) {
            for (int i = 0; i < vertices.size(); i++) {
                Point prev, cur, next;
                prev = vertices.get(i == 0 ? vertices.size() - 1 : i - 1);
                cur = vertices.get(i);
                next = vertices.get(i == vertices.size() - 1 ? 0 : i + 1);
                if (!insideAngle(prev, cur, next, p)) {
                    return false;
                }
            }
            return true;
        }

        private boolean insideAngle(Point prev, Point cur, Point next, Point p) {
            double n1 = (p.y - cur.y) * (next.x - cur.x) - (p.x - cur.x) * (next.y - cur.y);
            double n2 = (prev.y - cur.y) * (next.x - cur.x) - (prev.x - cur.x) * (next.y - cur.y);
            if (n1 * n2 >= 0) {
                n1 = (p.y - cur.y) * (prev.x - cur.x) - (p.x - cur.x) * (prev.y - cur.y);
                n2 = (next.y - cur.y) * (prev.x - cur.x) - (next.x - cur.x) * (prev.y - cur.y);
                if (n1 * n2 >= 0) {
                    return true;
                }
            }
            return false;
        }
    }

    private static class Ellipse implements ShapeMembershipCheckable {
        public Point leftFocal;
        public Point rightFocal;
        public Point top, bottom, left, right;
        private int majorAxis;
        public Ellipse(Point leftFocal, Point rightFocal, int semiMajorAxis) {
            this.leftFocal = leftFocal;
            this.rightFocal = rightFocal;
            this.majorAxis = semiMajorAxis * 2;

        }

        public boolean checkInside(Point p) {
            return p.getDistance(leftFocal) + p.getDistance(rightFocal) <= majorAxis;
        }
    }

    public static void main(String...main) {
        Scanner scn = new Scanner(System.in);
        List<ShapeMembershipCheckable> shapes = new ArrayList<>();
        // polygons
        int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            int e = scn.nextInt();
            List<Point> points = new ArrayList<>();
            for (int j = 0; j < e; j++) {
                int x = scn.nextInt(), y = scn.nextInt();
                points.add(new Point(x, y));
            }
            shapes.add(new Polygon(points));
        }

        // ellipses
        int m = scn.nextInt();
        for (int i = 0; i < m; i++) {
            Point f1 = new Point(scn.nextInt(), scn.nextInt());
            Point f2 = new Point(scn.nextInt(), scn.nextInt());
            int a = scn.nextInt();
            shapes.add(new Ellipse(f1, f2, a));
        }


    }
}
