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
        if (Math.abs(this.camera.getDistanceFromPlayer(this).x()) <= (double)Config.WINDOW_WIDTH / 4
                && Math.abs(this.camera.getDistanceFromPlayer(this).y()) <= (double)Config.WINDOW_HEIGHT / 4) {
            this.visible = true;
        } else {
            this.visible = false;
        }

        if (this.visible) {

            graphics2D.drawImage(this.image(), (int)this.position().x() - (int)this.camera.getPlayerOffset().x(),
                    (int)this.position().y() - (int)this.camera.getPlayerOffset().y(),
                    Config.TILE_SIZE, Config.TILE_SIZE, null);
        }

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