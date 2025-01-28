package tile;

import game.GameObject;
import game.Renderable;
import util.Camera;
import util.Config;
import util.Vector2;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TileMap implements Renderable {

    private BufferedImage image;
    private Tile[][] map;
    private Tile[][] renderingMap;
    private Camera camera;
    private int layer;
    private Graphics2D graphics2D;

    private int minX = 0;
    private int maxX = 0;
    private int minY = 0;
    private int maxY = 0;

    public TileMap() {

        this.setLayer(0);
        this.image = new BufferedImage(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT, 1);
        this.graphics2D = this.image.createGraphics();
        this.map = new Tile[Config.TILES_PER_HEIGHT][Config.TILES_PER_WIDTH];
        this.renderingMap = new Tile[Config.TILES_PER_SCREEN_HEIGHT][Config.TILES_PER_SCREEN_WIDTH];
    }

    public void loadMap() {
        for (int i = 0; i < Config.TILES_PER_HEIGHT; i++) {
            for (int j = 0; j < Config.TILES_PER_WIDTH; j++) {
                Tile tile = new TileGrass(j, i);
                tile.addCamera(this.camera);
                this.map[i][j] = tile;

            }
        }
    }

    public void updateRendering(Vector2 playerGridPosition) {
        if ((int)playerGridPosition.x() < Config.TILES_PER_SCREEN_WIDTH / 2) {
            this.minX = 0;
            this.maxX = Config.TILES_PER_SCREEN_WIDTH;
        } else if (Config.TILES_PER_WIDTH - (int)playerGridPosition.x() < Config.TILES_PER_SCREEN_WIDTH / 2) {
            this.minX = Config.TILES_PER_WIDTH - Config.TILES_PER_SCREEN_WIDTH;
            this.maxX = Config.TILES_PER_WIDTH;
        } else {
            this.minX = (int)playerGridPosition.x() - Config.TILES_PER_SCREEN_WIDTH / 2;
            this.maxX = (int)playerGridPosition.x() + Config.TILES_PER_SCREEN_WIDTH / 2 + 1;

            if ((int)playerGridPosition.x() > Config.TILES_PER_SCREEN_WIDTH / 2) {
                this.minX -= 1;
            }
        }

        if (Config.TILES_PER_HEIGHT - (int)playerGridPosition.y() < Config.TILES_PER_SCREEN_HEIGHT / 2) {
            this.minY = Config.TILES_PER_HEIGHT - Config.TILES_PER_SCREEN_HEIGHT;
            this.maxY = Config.TILES_PER_HEIGHT;
        } else if ((int)playerGridPosition.y() < Config.TILES_PER_SCREEN_HEIGHT / 2) {
            this.minY = 0;
            this.maxY = Config.TILES_PER_SCREEN_HEIGHT;
        } else {

            this.minY = (int)playerGridPosition.y() - Config.TILES_PER_SCREEN_HEIGHT / 2;
            this.maxY = (int)playerGridPosition.y() + Config.TILES_PER_SCREEN_HEIGHT / 2 + 1;

            if ((int)playerGridPosition.y() > Config.TILES_PER_SCREEN_HEIGHT / 2) {
                this.minY -= 1;
            }

        }



    }


    public void update() {

        this.graphics2D.setColor(Color.white);
        this.graphics2D.fillRect(0, 0, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);


        for (int i = this.minY; i < this.maxY; i++) {
            for (int j = this.minX; j < this.maxX; j++) {
                this.map[i][j].render(this.graphics2D);
            }
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