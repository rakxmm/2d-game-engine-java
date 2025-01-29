package renderable.tile;

import renderable.Renderable;
import util.Vector2;

import java.awt.*;

public abstract class Tile implements Renderable {
    private Vector2 gridPosition;
    private Vector2 position;
    private boolean onScreen = false;


    public Tile(int x, int y) {
        this.gridPosition = new Vector2(x, y);
    }

    @Override
    public void setGridPosition(Vector2 gridPosition) {
        this.gridPosition = gridPosition;
    }

    @Override
    public void setPosition(Vector2 position) {
        this.position = position;
    }

    @Override
    public Vector2 getGridPosition() {
        return this.gridPosition;
    }

    @Override
    public Vector2 getPosition() {
        return this.position;
    }

    public void setVisible(boolean value) {
        this.onScreen = value;
    }

    public boolean isOnScreen() {
        return this.onScreen;
    }

    @Override
    public void render(Graphics2D g) {
    }
}
