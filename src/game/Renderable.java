package game;

import util.Vector2;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Renderable implements Comparable<Renderable> {
    public abstract Vector2 getPosition();

    public abstract void setPosition(Vector2 position);

    public abstract void setImage(String fileName);

    public abstract BufferedImage image();

    public abstract void render(Graphics2D graphics2D);

    public abstract void setLayer(int layer);

    public abstract int layer();
}
