package tile;

import game.GameObject;
import game.Renderable;
import util.Camera;
import util.Config;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TileMap implements Renderable {

    private BufferedImage image;
    private List<Tile> map;
    private Camera camera;
    private int layer;

    public TileMap() {
        this.setLayer(0);
        this.image = new BufferedImage(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT, 1);
        this.map = new ArrayList<>();
    }

    public void loadMap() {
        for (int i = 0; i < Config.TILES_PER_HEIGHT; i++) {
            for (int j = 0; j < Config.TILES_PER_WIDTH; j++) {
                Tile tile = new TileGrass(j, i);
                tile.addCamera(this.camera);
                this.map.add(tile);
            }
        }
    }

    public void update() {
        Graphics2D g = this.image.createGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        Collections.sort(this.map);


        for (Tile t : this.map) {
            t.render(g);
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
    public int compareTo(Renderable o) {
        return Integer.compare(this.layer(), o.layer());
    }
}