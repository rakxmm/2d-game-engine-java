package renderable.entity;

import util.Vector2;

public interface Moveable {

    void move(Vector2 difference);

    void update();

    void right(boolean value);

    void left(boolean value);

    void up(boolean value);

    void down(boolean value);
}
