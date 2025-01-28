package tile;

import util.Vector2;

import java.util.Random;

public class TileGrass extends Tile {
    public TileGrass(int x, int y) {

        this.setLayer(0);
        this.setGridPosition(new Vector2(x, y));

        int image_num = new Random().nextInt(1,4);
        this.setImage("grass_" + image_num + ".png");
    }
}
