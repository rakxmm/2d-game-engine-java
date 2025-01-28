package renderable.tile;

import renderable.imageloader.ImageLoader;
import util.Config;
import util.Vector2;

import java.awt.*;

public class TileBlock extends Tile {

    public TileBlock(int x, int y) {
        this.setGridPosition(new Vector2(x, y));

    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(ImageLoader.getImage("grass_1.png"), this.getGridPosition().x() * Config.TILE_SIZE,
                this.getGridPosition().y() * Config.TILE_SIZE,
                Config.TILE_SIZE, Config.TILE_SIZE, null);
    }
}
