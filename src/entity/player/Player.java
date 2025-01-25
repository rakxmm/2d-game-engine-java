package entity.player;

import entity.Entity;

import entity.EntityDirection;
import entity.Moveable;
import util.Camera;
import util.Config;
import util.Vector2;

import java.awt.*;

public class Player extends Entity implements Moveable {
    private Camera camera;

    private double speed;

    private boolean left = false;
    private boolean right = false;
    private boolean down = false;
    private boolean up = false;

    private EntityDirection direction;

    public Player() {
        this.setSpeed(4);
        this.setLayer(1);
        this.setImage("character_16x16.png");
        this.setGridPosition(new Vector2(0, 0));
    }



    @Override
    public boolean move() {
        if (this.down) {
            this.setDirection(EntityDirection.DOWN);
            this.setPosition(this.position().addY(this.speed));
        } else if (this.up) {
            this.setDirection(EntityDirection.UP);
            this.setPosition(this.position().addY(-this.speed));
        } else if (this.left) {
            this.setDirection(EntityDirection.LEFT);
            this.setPosition(this.position().addX(-this.speed));
        } else if (this.right) {
            this.setDirection(EntityDirection.RIGHT);
            this.setPosition(this.position().addX(this.speed));
        } else {
            return false;
        }
        return true;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public double speed() {
        return this.speed;
    }

    @Override
    public void left(boolean value) {
        this.left = value;
    }

    @Override
    public void right(boolean value) {
        this.right = value;
    }

    @Override
    public void down(boolean value) {
        this.down = value;
    }

    @Override
    public void up(boolean value) {
        this.up = value;
    }

    @Override
    public void setDirection(EntityDirection direction) {
        this.direction = direction;
    }

    @Override
    public EntityDirection direction() {
        return this.direction;
    }

    @Override
    public void render(Graphics2D graphics2D) {
        graphics2D.drawImage(this.image(), (int)this.position().x() - (int)this.camera.getPlayerOffset().x(),
                (int)this.position().y() - (int)this.camera.getPlayerOffset().y(),
                Config.TILE_SIZE, Config.TILE_SIZE, null);
    }

    @Override
    public void addCamera(Camera camera) {
        this.camera = camera;
    }


}
