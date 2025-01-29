package game;

import renderable.Renderable;
import renderable.tile.TileBlock;
import tilemap.TileMap;
import util.Config;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

public class RenderManager extends Canvas {
    private Graphics2D graphics;
    private TileMap tileMap;

    private List<Renderable> renderableList;

    public RenderManager() {
        this.setPreferredSize(Config.CANVAS_DIMENSION);
        this.renderableList = new ArrayList<>();
    }

    public void add(Renderable r) {
        this.renderableList.add(r);
    }

    public void setTileMap(TileMap tm) {
        this.tileMap = tm;
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(2);
            return;
        }

        this.graphics = (Graphics2D)bs.getDrawGraphics();

        this.graphics.setColor(Color.black);
        this.graphics.fillRect(0, 0, Config.CANVAS_DIMENSION.width, Config.CANVAS_DIMENSION.height);

        this.graphics.drawImage(this.tileMap.getFrame(), 0, 0, Config.CANVAS_DIMENSION.width, Config.CANVAS_DIMENSION.height, null);

        for (Renderable r : this.renderableList) {
            r.render(this.graphics);
        }


        this.showFPS();
        this.graphics.dispose();
        bs.show();



    }

    private void showFPS() {
        this.graphics.setColor(Color.red);
        this.graphics.drawString("FPS: " + FPSCounter.get(), 0, 20);
    }
}
