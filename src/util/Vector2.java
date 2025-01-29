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


    public Vector2 addX(int x) {
        int v1 = this.x + x;
        int v2 = this.y;
        return new Vector2(v1, v2);
    }

    public Vector2 addY(int y) {
        int v1 = this.x;
        int v2 = this.y + y;
        return new Vector2(v1, v2);
    }

    public Vector2 diff(Vector2 vector) {
        return new Vector2(Math.abs(this.x - vector.x()), Math.abs(this.y - vector.y()));
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
