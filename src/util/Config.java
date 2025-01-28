package util;

import java.awt.*;

public class Config {

    // Dimensions //////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final Dimension CANVAS_DIMENSION = new Dimension(1920, 1024);

    public static final int TILES_PER_WIDTH = 60;
    public static final int TILES_PER_HEIGHT = 32;

    // Time ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final int TICK_RATE = 60;
    public static final int TICK = 1_000_000_000 / 60;

    // Tile ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final int DEF_TILE_SIZE = 32;
    private static final int TILE_SCALE = 2;
    public static final int TILE_SIZE = DEF_TILE_SIZE * TILE_SCALE;


}
