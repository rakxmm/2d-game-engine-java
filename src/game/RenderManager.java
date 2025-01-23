package game;

import util.Config;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

public class RenderManager extends Canvas {



    private List<Renderable> renderList;
    private Graphics2D graphics;


    public RenderManager() {
        this.renderList = new ArrayList<>();
        this.setBounds(0, 0, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void add(Renderable go)    {
        this.renderList.add(go);
    }


    public void render() {

        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            System.out.println("Creating buffer strategy!");
            this.createBufferStrategy(3);
            return;
        }

        this.graphics = (Graphics2D)bs.getDrawGraphics();

        for (Renderable r : this.renderList) {
            r.render(this.graphics);
        }

        this.graphics.dispose();
        bs.show();
    }


}
