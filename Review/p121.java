/******************************************************************************
 Prompt:

 Write a Point2D client that takes an integer value N from the command line,
 generates N random points in the unit square, and computes the distance
 separating the closest pair of points.

 I am aware this class is a bit of a mess. I first thought I'd keep track of x and y values in separate arrays.
 Then I decided I'd keep track of those values as an array of Points. So I created my own Point Class, but it has no
 useful methods, since I just made it, which is why we have libraries for this sort of thing. Then, I got a strange error about being unable to
 create an instance of the point class in a static method, so I made the maybe drastic decision to make this p121 class
 its own data type instead of just a script.

 I then started to realize that my approach to this problem, iterating over each point and comparing it to every other
 point, would would have a O(n^2) running time, which would be totally unacceptable for a sizeable number of points...
 A little searching an I start to realize I should probably sort the x or y coordinates and then compare the total distance
 between them, etc. but I am starting to think I may move on for now. Hell of a problem, i think for the first problem in
 a set! I'm going to brute force it for now, but I'm sure I'll come back to this problem...
 *
 ******************************************************************************/

public class p121 {
    Point[] points;

    public static void main(String[] args) {
        p121 p = new p121();
        try {
            int number_of_points = Integer.parseInt(args[0]);
            //testStdDraw();
            p.drawPoints(number_of_points);
            p.findClosestPoints();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please enter one numerical argument");
        } catch (java.lang.NumberFormatException e) {
            System.out.println("Please enter a number");
        }
    }

    public static void testStdDraw() {
        StdDraw.setPenRadius(0.05); //good to know, set a large pen radius and
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.point(0.5, 0.5);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.line(0.2, 0.2, 0.8, 0.2);
    }

    public void drawPoints(int number_of_points) {
        StdDraw.setPenRadius(0.05);
        points = new Point[5];
        StdDraw.setPenColor(StdDraw.BLUE);
        for (int i = 0; i < number_of_points; i++) {
            double x = StdRandom.random();
            double y = StdRandom.random();
            Point point = new Point(x, y);
            System.out.print(point.toString());
            points[i] = point;
            StdDraw.point(x, y);
        }
    }

    public Point[] findClosestPoints() {
        Point[] closestPair = new Point[2];
        double distance;
        double smallest_distance = Double.POSITIVE_INFINITY;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                distance = findDistance(points[i], points[j]);
                if (distance < smallest_distance) {
                    closestPair[0] = points[i];
                    closestPair[1] = points[j];
                }
            }
        }
        //System.out.println("point1: " + closestPair[0].get_x_coord() + " " + closestPair[0].get_y_coord());
        //System.out.println("point2: " + closestPair[1].get_x_coord() + " " + closestPair[1].get_y_coord());
        System.out.println(smallest_distance);
        StdDraw.line(closestPair[0].get_x_coord(), closestPair[0].get_y_coord(),
                closestPair[1].get_x_coord(), closestPair[1].get_y_coord());
        return closestPair;
    }

    public static double findDistance(Point point1, Point point2) {
        double y_difference = (point1.get_y_coord() - point2.get_y_coord());
        y_difference *= y_difference;
        double x_difference = (point1.get_x_coord() - point2.get_x_coord());
        x_difference *= x_difference;
        double distance = Math.sqrt(x_difference + y_difference);
        System.out.println(distance);
        return distance;
    }

    private class Point {
        private double x_coord;
        private double y_coord;

        public Point(double x, double y) {
            x_coord = x;
            y_coord = y;
        }

        public double get_x_coord() {
            return x_coord;
        }

        public double get_y_coord() {
            return y_coord;
        }

        public String toString() {
            return "" + x_coord + " , " + y_coord;
        }
    }
}
