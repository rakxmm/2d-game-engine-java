package renderable.entity.player;

import renderable.Controllable;
import renderable.entity.Entity;
import renderable.entity.Moveable;
import renderable.imageloader.ImageLoader;
import util.Camera;
import util.Config;
import util.Vector2;

import java.awt.*;

public class Player extends Entity implements Moveable {

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;


    public Player() {
    }





    @Override
    public void render(Graphics2D g) {
        g.drawImage(ImageLoader.getImage("down_1.png"), this.getPosition().x() - Camera.getPosition().x(), this.getPosition().y() - Camera.getPosition().y(), Config.TILE_SIZE, Config.TILE_SIZE, null);
    }



    @Override
    public void move(Vector2 difference) {
        int x = this.getPosition().x() + difference.x();
        int y = this.getPosition().y() + difference.y();

        System.out.println("moving");

        if (x > 0 && x + Config.TILE_SIZE < Config.MAP_WIDTH && y > 0 && y + Config.TILE_SIZE < Config.MAP_HEIGHT) {
            this.setPosition(this.getPosition().add(difference));
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


}
