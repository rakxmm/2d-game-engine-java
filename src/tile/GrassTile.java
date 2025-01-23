package tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GrassTile extends Tile {

    public GrassTile(int x, int y) {
        super(x, y);
        this.setImage("green16_16.png");
        this.setLayer(0);
    }

}
