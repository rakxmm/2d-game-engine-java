package util;

import java.awt.*;

public class Config {

    // Dimensions //////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final Dimension CANVAS_DIMENSION = new Dimension(1280, 704);


    // Tile ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final int DEF_TILE_SIZE = 32;
    private static final int TILE_SCALE = 2;
    public static final int TILE_SIZE = DEF_TILE_SIZE * TILE_SCALE;

    public static final int TILES_PER_WIDTH = 60;
    public static final int TILES_PER_HEIGHT = 32;
    public static final int TILES_PER_SCREEN_HEIGHT = 1920 / 64;
    public static final int TILES_PER_SCREEN_WIDTH = 1024 / 64;

    // Map /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final int MAP_WIDTH = TILE_SIZE * TILES_PER_WIDTH;
    public static final int MAP_HEIGHT = TILE_SIZE * TILES_PER_HEIGHT;

    // Time ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final int TICK_RATE = 60;
    public static final int TICK = 1_000_000_000 / 60;



    // Chunk ///////////////////////////////////////////////////////////////////////////////////////////////////////////



}
