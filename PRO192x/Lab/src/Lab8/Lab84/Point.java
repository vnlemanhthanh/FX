package Lab8.Lab84;

/** public boolean isVertical(Point other)
 * Returns true if the given Point lines up vertically with this Point;
 * that is, if their x coordinates are the same.*/
public class Point {
    private int x;
    private int y;

    public boolean isVertical(Point other) {
        return (this.x == other.x);
    }
}
