package game;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public interface Renderable extends Comparable<Renderable> {
    void setImage(String fileName);

    BufferedImage image();

    void render(Graphics2D graphics2D);

    void setLayer(int layer);

    int layer();
}
