package tile;

import util.Vector2;

public class TileGrass extends Tile {
    public TileGrass(int x, int y) {
        this.setLayer(0);
        this.setPosition(new Vector2(x, y));
        this.setImage("green16_16.png");
    }
}
