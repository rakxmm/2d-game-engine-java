package game;

import util.Config;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

public class RenderManager extends Canvas {


    private final List<Renderable> list;

    private Graphics2D graphics;

    public RenderManager() {
        this.list = new ArrayList<>();
        this.setBounds(0, 0, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void addRenderable(Renderable renderable) {
        this.list.add(renderable);
    }

    public void addRenderable(List<Renderable> renderable) {
        this.list.addAll(renderable);
    }

    public void render() {

        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            System.out.println("Creating buffer strategy!");
            this.createBufferStrategy(3);
            return;
        }

        this.graphics = (Graphics2D)bs.getDrawGraphics();

        for (Renderable r: this.list) {
            r.render(this.graphics);
        }

        this.graphics.dispose();
        bs.show();
    }


}
