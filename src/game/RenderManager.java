package game;

import entity.player.Player;
import util.Config;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RenderManager extends Canvas {



    private List<Renderable> renderList;
    private Graphics2D graphics;



    public RenderManager() {
        this.renderList = new ArrayList<>();
        this.setPreferredSize(new Dimension(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT));
        this.setVisible(true);
    }

    public void add(Renderable go)    {
        this.renderList.add(go);
        Collections.sort(this.renderList);
    }


    public void render() {

        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            System.out.println("Creating buffer strategy!");
            this.createBufferStrategy(2);
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
