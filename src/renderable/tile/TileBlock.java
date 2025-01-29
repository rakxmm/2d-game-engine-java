package renderable.tile;

import renderable.imageloader.ImageLoader;
import util.Camera;
import util.Config;

import java.awt.*;

public class TileBlock extends Tile {

    public TileBlock(int x, int y) {
        super(x, y);
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(ImageLoader.getImage("grass_1.png"), this.getGridPosition().x() * Config.TILE_SIZE - Camera.offX(this),
                this.getGridPosition().y() * Config.TILE_SIZE - Camera.offY(this),
                Config.TILE_SIZE, Config.TILE_SIZE, null);
    }
}
