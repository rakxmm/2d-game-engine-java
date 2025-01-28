package entity.player;

import entity.Animatable;
import entity.Entity;

import entity.EntityDirection;
import entity.Moveable;
import util.Camera;
import util.Config;
import util.Vector2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity implements Moveable, Animatable {
    private Camera camera;

    private double speed;

    private boolean left = false;
    private boolean right = false;
    private boolean down = false;
    private boolean up = false;

    private int frame = 0;

    private boolean moving = false;

    private EntityDirection direction = EntityDirection.DOWN;

    private BufferedImage[] leftFrames;
    private BufferedImage[] rightFrames;
    private BufferedImage[] upFrames;
    private BufferedImage[] downFrames;


    public Player() {
        this.loadFrames();
        this.setSpeed(Config.PLAYER_SPEED);
        this.setLayer(1);
        this.setGridPosition(new Vector2(0, 0));
    }

    @Override
    public void updateFrame() {
        this.frame++;
    }

    @Override
    public boolean move() {


        if (this.down) {
            if (this.gridPosition().y() + 1 < Config.TILES_PER_HEIGHT) {
                this.setDirection(EntityDirection.DOWN);
                this.setPosition(this.position().addY(this.speed));
            }

        } else if (this.up) {
            if (this.gridPosition().y() > 0) {
                this.setDirection(EntityDirection.UP);
                this.setPosition(this.position().addY(-this.speed));
            }

        } else if (this.left) {
            if (this.gridPosition().x() > 0) {
                this.setDirection(EntityDirection.LEFT);
                this.setPosition(this.position().addX(-this.speed));
            }

        } else if (this.right) {
            if (this.gridPosition().x() + 1 < Config.TILES_PER_WIDTH) {
                this.setDirection(EntityDirection.RIGHT);
                this.setPosition(this.position().addX(this.speed));
            }

        } else {
            this.moving = false;
            return false;
        }
        this.moving = true;
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
    public boolean isMoving() {
        return this.moving;
    }

    @Override
    public void render(Graphics2D graphics2D) {
        graphics2D.drawImage(this.image(), (int)this.position().x() - (int)this.camera.getPlayerOffsetX(),
                (int)this.position().y() - (int)this.camera.getPlayerOffsetY(),
                Config.PLAYER_SIZE, Config.PLAYER_SIZE, null);
    }

    @Override
    public void addCamera(Camera camera) {
        this.camera = camera;
    }


    @Override
    public void loadFrames() {
        this.leftFrames = new BufferedImage[2];
        this.rightFrames = new BufferedImage[3];
        this.upFrames = new BufferedImage[1];
        this.downFrames = new BufferedImage[2];

        try {


            this.rightFrames[0] = ImageIO.read(new File(Config.pathToImages + "r1.png"));
            this.rightFrames[1] = ImageIO.read(new File(Config.pathToImages + "r2.png"));
            this.rightFrames[2] = ImageIO.read(new File(Config.pathToImages + "r3.png"));

            this.leftFrames[0] = ImageIO.read(new File(Config.pathToImages + "left_1.png"));
            this.leftFrames[1] = ImageIO.read(new File(Config.pathToImages + "left_2.png"));

            this.upFrames[0] = ImageIO.read(new File(Config.pathToImages + "up_1.png"));

            this.downFrames[0] = ImageIO.read(new File(Config.pathToImages + "down_2.png"));
            this.downFrames[1] = ImageIO.read(new File(Config.pathToImages + "down_3.png"));



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BufferedImage image() {
        switch (this.direction) {
            case RIGHT:
                if (this.frame >= this.rightFrames.length) {
                    this.frame = 0;
                }
                return this.rightFrames[this.frame];
            case LEFT:
                if (this.frame >= this.leftFrames.length) {
                    this.frame = 0;
                }
                return this.leftFrames[this.frame];
            case DOWN:
                if (this.frame >= this.downFrames.length) {
                    this.frame = 0;
                }
                return this.downFrames[this.frame];
            case UP:
                if (this.frame >= this.upFrames.length) {
                    this.frame = 0;
                }
                return this.upFrames[this.frame];
        }
        return this.downFrames[0];
    }
}
