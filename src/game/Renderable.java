package game;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public interface Renderable {
    void setImage(String fileName);

    BufferedImage image();

    void render(Graphics2D graphics2D);
}
