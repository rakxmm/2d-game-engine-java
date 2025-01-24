package entity;

import game.GameObject;
import game.Renderable;
import util.Config;
import util.Vector2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Entity extends GameObject {

    private Vector2 position;
    private BufferedImage image;
    private int layer;


    @Override
    public void setPosition(Vector2 position) {
        this.position = position;
    }

    @Override
    public Vector2 position() {
        return this.position;
    }

    @Override
    public void setImage(String fileName) {
        try {
            this.image = ImageIO.read(new File("res/images/" + fileName));
        } catch (IOException e) {
            System.out.println("@Entity @setImage, failed to load an image!");
        }
    }

    @Override
    public BufferedImage image() {
        return this.image;
    }

    @Override
    public void setLayer(int layer) {
        this.layer = layer;
    }

    @Override
    public int layer() {
        return this.layer;
    }

    @Override
    public int compareTo(Renderable o) {
        return Integer.compare(this.layer, o.layer());
    }

    @Override
    public void render(Graphics2D graphics2D) {
        graphics2D.drawImage(this.image(), (int)this.position().x() * Config.TILE_SIZE, (int)this.position().y() * Config.TILE_SIZE,
                Config.TILE_SIZE, Config.TILE_SIZE, null);
    }
}
