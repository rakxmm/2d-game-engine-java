package tile;

import game.Renderable;
import util.Config;
import util.Vector2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Tile extends Renderable {
    private Vector2 position;

    private BufferedImage image;
    private int layer;


    public Tile(Vector2 position) {
        this.position = position;
    }

    public Tile(int x, int y) {
        this(new Vector2(x, y));
    }

    public void render(Graphics2D graphics2D) {
        graphics2D.drawImage(this.image(), (int)this.position.x() * Config.TILE_SIZE, (int)this.position.y() * Config.TILE_SIZE,
                Config.TILE_SIZE, Config.TILE_SIZE, null);
    }

    public void setImage(String fileName) {
        try {
            this.image = ImageIO.read(new File("res/images/" + fileName));
        } catch (IOException e) {
            System.out.println("@Tile @setImage | failed to load image from file!");
        }
    }

    public BufferedImage image() {
        return this.image;
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public int layer() {
        return this.layer;
    }

    @Override
    public int compareTo(Renderable o) {
        return Integer.compare(this.layer, o.layer());
    }
}
