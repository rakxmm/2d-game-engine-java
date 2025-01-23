package tile;

import game.GameObject;
import game.Renderable;
import util.Config;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.util.ArrayList;
import java.util.List;

public class TileMap implements Renderable {

    private BufferedImage image;
    private List<Tile> map;

    public TileMap() {
        this.image = new BufferedImage(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT, 1);
        this.map = new ArrayList<>();
        this.loadMap();
        this.update();
    }

    private void loadMap() {
        for (int i = 0; i < Config.TILES_PER_HEIGHT; i++) {
            for (int j = 0; j < Config.TILES_PER_WIDTH; j++) {
                this.map.add(new TileGrass(j, i));
            }
        }
    }

    public void update() {
        Graphics2D g = this.image.createGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        for (Tile t : this.map) {
            g.drawImage(t.image(), (int)t.position().x() * Config.TILE_SIZE, (int)t.position().y() * Config.TILE_SIZE,
                    Config.TILE_SIZE, Config.TILE_SIZE, null);
        }
    }

    @Override
    public void setImage(String fileName) {
        // ignore
    }

    @Override
    public BufferedImage image() {
        return this.image;
    }

    @Override
    public void render(Graphics2D graphics2D) {
        graphics2D.drawImage(this.image, 0, 0, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT, null);
    }
}