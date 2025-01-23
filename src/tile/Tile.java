package tile;

import game.GameObject;
import game.Layerable;
import util.Config;
import util.Vector2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

public abstract class Tile extends GameObject {
    private Vector2 position;
    private BufferedImage image;
    private int layer;

    @Override
    public void setImage(String fileName) {
        try {
            this.image = ImageIO.read(new File("res/images/" + fileName));
        } catch (IOException e) {
            System.out.println("@Tile @setImage, failed to load an image!");
        }
    }

    @Override
    public BufferedImage image() {
        return this.image;
    }

    @Override
    public void setPosition(Vector2 position) {
        this.position = position;
    }

    @Override
    public Vector2 position() {
        return this.position;
    }

    @Override
    public int compareTo(Layerable o) {
        return Integer.compare(this.layer(), o.layer());
    }

    @Override
    public void render(Graphics2D graphics2D) {
        graphics2D.drawImage(this.image(), (int)this.position().x() * Config.TILE_SIZE, (int)this.position().y() * Config.TILE_SIZE,
                Config.TILE_SIZE, Config.TILE_SIZE, null);
    }

    @Override
    public void setLayer(int layer) {
        this.layer = layer;
    }

    @Override
    public int layer() {
        return this.layer;
    }
}