package game;

import util.Vector2;

public abstract class GameObject implements Renderable {
    public abstract void setPosition(Vector2 position);

    public abstract Vector2 position();

    public abstract void setGridPosition(Vector2 position);

    public abstract Vector2 gridPosition();
}
