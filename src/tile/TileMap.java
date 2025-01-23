package tile;

import game.Renderable;
import util.Config;
import util.Vector2;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TileMap extends Renderable {
    private final List<Renderable> map;


    public TileMap() {
        this.map = new ArrayList<>();
        this.loadMap();
    }

    public void loadMap() {
        for (int i = 0; i < Config.TILES_PER_HEIGHT; i++) {
            for (int j = 0; j < Config.TILES_PER_WIDTH; j++) {
                this.add(new GrassTile(j, i));
            }
        }
    }

    public void add(Tile t) {
        if (this.contains(t.getPosition()) == null) {
            this.map.add(t);
            Collections.sort(this.map);
        }
    }

    private Renderable contains(Vector2 position) {
        for (Renderable t: this.map) {
            if (t.getPosition().equals(position)) {
                return t;
            }
        }
        return null;
    }

    public List<Renderable> getMap() {
        return this.map;
    }


    public void render(Graphics2D graphics2D) {
        for (Renderable t : this.map) {
            t.render(graphics2D);
        }
    }

    @Override
    public Vector2 getPosition() {
        return null;
    }

    @Override
    public void setPosition(Vector2 position) {

    }

    @Override
    public void setImage(String fileName) {
        // ignore
    }

    @Override
    public BufferedImage image() {
        return null;
        // ignore
    }

    @Override
    public void setLayer(int layer) {
        // ignore
    }

    @Override
    public int layer() {
        // ignore
        return 0;
    }

    @Override
    public int compareTo(Renderable o) {
        // ignore
        return 0;
    }
}
