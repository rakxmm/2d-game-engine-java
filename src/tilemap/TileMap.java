package tilemap;

import renderable.tile.Tile;
import renderable.tile.TileBlock;
import renderable.tile.TileEmpty;
import util.Config;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class TileMap {

    private Tile[][] map;
    private BufferedImage image;
    private Graphics2D graphics;

    public TileMap() {
        this.map = new Tile[Config.TILES_PER_HEIGHT][Config.TILES_PER_WIDTH];
        this.image = new BufferedImage(Config.CANVAS_DIMENSION.width, Config.CANVAS_DIMENSION.height, BufferedImage.TYPE_INT_RGB);
        this.graphics = this.image.createGraphics();
        this.init();
    }

    private void init() {
        for (int i = 0; i < Config.TILES_PER_HEIGHT; i++) {
            for (int j = 0; j < Config.TILES_PER_WIDTH; j++) {
                if (i == 0 || j == 0 || i == Config.TILES_PER_HEIGHT - 1 || j == Config.TILES_PER_WIDTH - 1) {
                    this.map[i][j] = new TileBlock(j, i);
                } else {
                    this.map[i][j] = new TileEmpty(j, i);
                }

                this.map[i][j].render(this.graphics);

            }
        }
    }

    public void update() {
        this.graphics.setColor(Color.black);
        this.graphics.fillRect(0, 0, Config.CANVAS_DIMENSION.width, Config.CANVAS_DIMENSION.height);

        for (int i = 0; i < Config.TILES_PER_HEIGHT; i++) {
            for (int j = 0; j < Config.TILES_PER_WIDTH; j++) {
                this.map[i][j].render(this.graphics);
            }
        }
    }

    public BufferedImage getFrame() {
        return this.image;
    }
}
