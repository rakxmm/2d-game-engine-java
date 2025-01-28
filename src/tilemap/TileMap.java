package tilemap;

import renderable.tile.Tile;
import util.Config;

import java.awt.image.BufferedImage;

public class TileMap {

    private Tile[][] map;
    private BufferedImage image;

    public TileMap() {
        this.map = new Tile[Config.TILES_PER_HEIGHT][Config.TILES_PER_WIDTH];
        this.image = new BufferedImage(Config.TILE_SIZE, Config.TILE_SIZE, BufferedImage.TYPE_INT_RGB);
    }

    public void update() {

    }
}
