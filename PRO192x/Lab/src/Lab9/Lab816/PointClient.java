package Lab9.Lab816;

public class PointClient {
    public static void main(String[] args) {

                // construct two Point objects, one at (8, 2) and one at (4, 3)
        Point p1 = new Point(8, 2);
        Point p2 = new Point(4, 3);

                // display the two Point objects' state
                System.out.println("p1 is " + p1.toString());
                System.out.println("p2 is " + p2.toString());

                // display p1 distance from origin
                System.out.println("p1's distance from origin is " + p1.distanceFromOrigin());

                // translate p1 to (9, 4)
                p1.translate(1, 2);
                // translate p2 to (3, 13)
                p2.translate(-1, 10);

                // display the two Point objects' state again
                System.out.println("p1 is now " + p1.toString());
                System.out.println("p2 is now " + p2.toString());
            }
}

// A Point object represents a pair of (x, y) coordinates.
// (Point class must be submitted with your solution; do not modify!)
class Point {
    public int x;
    public int y;

    public Point() {
        setLocation(0, 0);
    }

    public Point(int x, int y) {
        setLocation(x, y);
    }

    public double distanceFromOrigin() {
        return distance(new Point());
    }

    public double distance(Point p) {
        int dx = x - p.x;
        int dy = y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public void translate(int dx, int dy) {
        setLocation(x + dx, y + dy);
    }
}
