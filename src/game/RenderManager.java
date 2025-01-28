package game;

import renderable.tile.TileBlock;
import util.Config;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class RenderManager extends Canvas {
    private Graphics2D graphics;
    public RenderManager() {
        this.setPreferredSize(Config.CANVAS_DIMENSION);
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

        new TileBlock(10, 10).render(this.graphics);

        this.graphics.dispose();
        bs.show();



    }


}
