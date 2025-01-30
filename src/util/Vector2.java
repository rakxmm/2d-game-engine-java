package util;

public class Vector2 {
    private int x;
    private int y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 add(Vector2 vector) {
        int v1 = vector.x() + this.x;
        int v2 = vector.y() + this.y;
        return new Vector2(v1, v2);
    }


    public void addX(int x) {
        this.x += x;
    }

    public void addY(int y) {
        this.y += y;
    }

    public Vector2 diff(Vector2 vector) {
        return new Vector2(this.x - vector.x(), this.y - vector.y());
    }

    public boolean equals(Vector2 v) {
        if (this.x == v.x() && this.y == v.y()) {
            return true;
        }
        return false;
    }

    public int x() {
        return this.x;
    }
    public int y() {
        return this.y;
    }

    @Override
    public String toString() {
        return "[" + this.x + " , " + this.y + "]";
    }
}
