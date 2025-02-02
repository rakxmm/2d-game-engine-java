package renderable.tile;

import game.InteractionsManager;
import renderable.Collidable;
import renderable.CollidableState;
import renderable.Interactable;
import renderable.entity.Entity;
import util.Camera;
import util.Config;
import util.Vector2;

import java.awt.Color;
import java.awt.Graphics2D;


public class TileInteract extends Tile implements Collidable, Interactable {

    private CollidableState state = CollidableState.SOLID;
    public TileInteract(int x, int y) {
        super(x, y);
        InteractionsManager.getInstance().addInteractable(this);
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.green);
        g.fillRect(this.getGridPosition().x() * this.getSize().x() - Camera.getInstance().getPosition().x(),
                this.getGridPosition().y() * this.getSize().y() - Camera.getInstance().getPosition().y(),
                this.getSize().x(), this.getSize().y());

        g.setColor(Color.white);
        g.drawRect(this.getGridPosition().x() * this.getSize().x() - 50 - Camera.getInstance().getPosition().x(),
                this.getGridPosition().y() * this.getSize().y() - 50 - Camera.getInstance().getPosition().y(),
                this.getSize().x() + 100, this.getSize().y() + 100);
    }

    @Override
    public boolean collide(Collidable collidable, Vector2 possiblePosition) {
        return false;
    }

    @Override
    public Vector2 getSize() {
        return new Vector2(Config.TILE_SIZE, Config.TILE_SIZE);
    }

    @Override
    public CollidableState getState() {
        return this.state;
    }

    @Override
    public Vector2 getPosition() {
        return new Vector2(this.getGridPosition().x() * this.getSize().x(), this.getGridPosition().y() * this.getSize().y());
    }

    @Override
    public void handleInteraction(Entity e) {
        System.out.println("Interacted with an interactive tile! " + e.getPosition());
    }

    @Override
    public boolean inDistance(Entity e) {
        int x = this.getPosition().x();
        int y = this.getPosition().y();


        int eXSize = e.getSize().x();
        int eYSize = e.getSize().y();

        int eX = e.getPosition().x();
        int eY = e.getPosition().y();

        return x + this.getSize().x() >= eX - 50
                && x  <= eX + eXSize + 50
                && y + this.getSize().y() >= eY - 50
                && y  <= eY + eYSize + 50;

    }
}
