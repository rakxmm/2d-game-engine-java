package tile;

import game.GameObject;
import game.Renderable;
import util.Camera;
import util.Config;
import util.Vector2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public abstract class Tile extends GameObject {
    private Vector2 position;
    private Vector2 gridPosition;
    private BufferedImage image;
    private int layer;
    private Camera camera;

    private boolean visible;



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
    public int compareTo(Renderable o) {
        return Integer.compare(this.layer(), o.layer());
    }

    @Override
    public void render(Graphics2D graphics2D) {
        int x  = (int)this.position().x() - (int)this.camera.getPlayerOffsetX();
        int y = (int)this.position().y() - (int)this.camera.getPlayerOffsetY();


        graphics2D.drawImage(this.image(), x, y,
                Config.TILE_SIZE, Config.TILE_SIZE, null);

    }

    public boolean isVisible() {
        int x  = (int)this.position().x() - (int)this.camera.getPlayerOffsetX();
        int y = (int)this.position().y() - (int)this.camera.getPlayerOffsetY();

        if (x + Config.TILE_SIZE < 0 || x > Config.WINDOW_WIDTH || y + Config.TILE_SIZE < 0 || y > Config.WINDOW_HEIGHT) {
            return false;
        }
        return true;
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
    public void addCamera(Camera camera) {
        this.camera = camera;
    }

    @Override
    public Vector2 gridPosition() {
        return this.gridPosition;
    }
    @Override
    public void setGridPosition(Vector2 gridPosition) {
        this.gridPosition = gridPosition;
        this.position = new Vector2(this.gridPosition.x() * Config.TILE_SIZE, this.gridPosition.y() * Config.TILE_SIZE);
    }
}