package renderable.tile;

import game.CollisionsManager;
import renderable.Collidable;
import renderable.CollidableState;
import util.Camera;
import util.Config;
import util.Vector2;

import java.awt.*;

public class TileBlock extends Tile implements Collidable {

    private Vector2 size;
    private CollidableState state = CollidableState.SOLID;

    public TileBlock(int x, int y) {
        super(x, y);
        this.size = new Vector2(Config.TILE_SIZE, Config.TILE_SIZE);
        CollisionsManager.getInstance().addCollidable(this);
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.blue);
        g.fillRect(this.getGridPosition().x() * this.size.x() - Camera.getInstance().getPosition().x(),
                this.getGridPosition().y() * this.size.y() - Camera.getInstance().getPosition().y(),
                this.size.x(), this.size.y());
    }

    @Override
    public Vector2 getSize() {
        return this.size;
    }

    @Override
    public boolean collide(Collidable collidable, Vector2 newPosition) {
        int x = newPosition.x();
        int y = newPosition.y();

        return this.getPosition().x() + this.getSize().x() > x
                && this.getPosition().x() < x + collidable.getSize().x()
                && this.getPosition().y() + this.getSize().y() > y
                && this.getPosition().y() < y + collidable.getSize().y();

    }

    @Override
    public Vector2 getPosition() {
        return new Vector2(this.getGridPosition().x() * this.size.x(), this.getGridPosition().y() * this.size.y());
    }

    @Override
    public CollidableState getState() {
        return this.state;
    }
}
