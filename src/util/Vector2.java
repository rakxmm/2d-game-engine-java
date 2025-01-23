package util;

public class Vector2 {
    private double x;
    private double y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void add(Vector2 vector) {
        this.x += vector.x();
        this.y += vector.y();
    }

    public boolean equals(Vector2 v) {
        if (this.x == v.x() && this.y == v.y()) {
            return true;
        }
        return false;
    }

    public double x() {
        return this.x;
    }
    public double y() {
        return this.y;
    }
}
