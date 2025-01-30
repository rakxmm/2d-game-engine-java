package tilemap;

import renderable.tile.Tile;
import renderable.tile.TileEmpty;
import util.Camera;
import util.Config;
import util.Vector2;

import java.awt.*;
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
                this.map[i][j] = new Tile(j, i) {
                    @Override
                    public void render(Graphics2D g) {
                        g.setColor(new Color(255, 0, 0, 255));

                        int x = this.getGridPosition().x() * Config.TILE_SIZE;
                        int y = this.getGridPosition().y() * Config.TILE_SIZE;
                        this.setPosition(new Vector2(x, y));

                        if (this.getGridPosition().y() == 0 || this.getGridPosition().y() == Config.TILES_PER_HEIGHT - 1 || this.getGridPosition().x() == 0 || this.getGridPosition().x() == Config.TILES_PER_WIDTH - 1) {
                            g.setColor(Color.pink);
                        }
                        g.drawRect(this.getGridPosition().x() * Config.TILE_SIZE - Camera.getPosition().x(), this.getGridPosition().y() * Config.TILE_SIZE - Camera.getPosition().y(), Config.TILE_SIZE, Config.TILE_SIZE);
                    }
                };
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
