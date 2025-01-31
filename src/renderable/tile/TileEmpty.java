package renderable.tile;

import util.Camera;
import util.Config;

import java.awt.Color;
import java.awt.Graphics2D;

public class TileEmpty extends Tile {

    public TileEmpty(int x, int y) {
        super(x, y);
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.red);
        g.drawRect(this.getGridPosition().x() * Config.TILE_SIZE - Camera.getInstance().getPosition().x(),
                this.getGridPosition().y() * Config.TILE_SIZE - Camera.getInstance().getPosition().y(),
                Config.TILE_SIZE, Config.TILE_SIZE);
    }
}
