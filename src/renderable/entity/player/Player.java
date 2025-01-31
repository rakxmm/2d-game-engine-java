package renderable.entity.player;

import game.CollisionsManager;
import renderable.Collidable;
import renderable.CollidableState;
import renderable.entity.CameraLockable;
import renderable.entity.Entity;
import renderable.entity.Moveable;
import renderable.imageloader.ImageLoader;
import util.Camera;
import util.Config;
import util.Vector2;

import java.awt.Graphics2D;

public class Player extends Entity implements Moveable, CameraLockable, Collidable {

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    private CollidableState state = CollidableState.SOLID;

    public Player() {
        this.setLayer(3);
    }





    @Override
    public void render(Graphics2D g) {
        g.drawImage(ImageLoader.getImage("down_1.png"),
                this.getPosition().x() - Camera.getInstance().getPosition().x(),
                this.getPosition().y() - Camera.getInstance().getPosition().y(),
                Config.TILE_SIZE, Config.TILE_SIZE, null);
    }



    @Override
    public void move(Vector2 difference) {
        int x = this.getPosition().x() + difference.x();
        int y = this.getPosition().y() + difference.y();

        if (x >= 0 && x + Config.TILE_SIZE <= Config.MAP_WIDTH && y >= 0 && y + Config.TILE_SIZE <= Config.MAP_HEIGHT) {
            Vector2 newPosition = this.getPosition().add(difference);
            if (CollisionsManager.getInstance().canMove(this, newPosition)) {
                this.setPosition(newPosition);
            }
        }

    }

    @Override
    public void update() {
        if (this.up) {
            this.move(new Vector2(0, -Config.PLAYER_SPEED));
        } else if (this.down) {
            this.move(new Vector2(0, Config.PLAYER_SPEED));
        } else if (this.right) {
            this.move(new Vector2(Config.PLAYER_SPEED, 0));
        } else if (this.left) {
            this.move(new Vector2(-Config.PLAYER_SPEED, 0));
        }
    }

    @Override
    public void right(boolean value) {
        this.right = value;
    }

    @Override
    public void left(boolean value) {
        this.left = value;
    }

    @Override
    public void up(boolean value) {
        this.up = value;
    }

    @Override
    public void down(boolean value) {
        this.down = value;
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
    public Vector2 getSize() {
        return new Vector2(Config.TILE_SIZE, Config.TILE_SIZE);
    }

    @Override
    public CollidableState getState() {
        return this.state;
    }
}
