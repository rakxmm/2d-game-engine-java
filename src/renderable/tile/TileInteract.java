package renderable.tile;

import renderable.Collidable;
import renderable.CollidableState;
import util.Vector2;

public class TileInteract extends Tile implements Collidable {

    public TileInteract(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean collide(Collidable collidable, Vector2 possiblePosition) {
        return false;
    }

    @Override
    public Vector2 getSize() {
        return null;
    }

    @Override
    public CollidableState getState() {
        return null;
    }
}
