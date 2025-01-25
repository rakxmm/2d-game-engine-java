package entity;

import util.Vector2;

public interface Moveable {
    boolean move();

    void setSpeed(double speed);

    double speed();

    void left(boolean value);

    void right(boolean value);

    void down(boolean value);

    void up(boolean value);

    void setDirection(EntityDirection direction);

    EntityDirection direction();

}
