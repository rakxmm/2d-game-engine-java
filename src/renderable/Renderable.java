package renderable;

import util.Vector2;

import java.awt.*;

public interface Renderable extends Comparable<Renderable> {
    void render(Graphics2D g);

    void setGridPosition(Vector2 gridPosition);

    void setPosition(Vector2 position);

    Vector2 getGridPosition();

    Vector2 getPosition();

    int layer();
}
