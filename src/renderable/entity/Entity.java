package renderable.entity;

import renderable.Renderable;
import util.Config;
import util.Vector2;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity implements Renderable {



    private Vector2 position;

    private int layer;





    @Override
    public void setGridPosition(Vector2 gridPosition) {
    }

    public void setDefaultPosition(Vector2 defaultPosition) {
        Vector2 pos = new Vector2(defaultPosition.x() * Config.TILE_SIZE, defaultPosition.y() * Config.TILE_SIZE);
        this.setPosition(pos);
    }

    @Override
    public void setPosition(Vector2 position) {
        this.position = position;
    }

    @Override
    public Vector2 getGridPosition() {
        return null;
    }

    @Override
    public Vector2 getPosition() {
        return this.position;
    }

    @Override
    public int layer() {
        return this.layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    @Override
    public int compareTo(Renderable o) {
        return Integer.compare(this.layer(), o.layer());
    }
}
