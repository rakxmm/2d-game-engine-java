package util;

public class Config {

    private static final int TILE_SCALE = 1;
    private static final int DEFAULT_TILE_SIZE = 32;

    public static final int PLAYER_SIZE = 64;

    public static final int TILE_SIZE = DEFAULT_TILE_SIZE * TILE_SCALE;

    public static final int WINDOW_WIDTH = 1280;
    public static final int WINDOW_HEIGHT = 704;




    public static final int TILES_PER_WIDTH = 60;
    public static final int TILES_PER_HEIGHT = 50;


    public static final int SCREEN_MIN = 0;
    public static final int SCREEN_MAX_H = TILES_PER_HEIGHT * TILE_SIZE;
    public static final int SCREEN_MAX_W = TILES_PER_WIDTH * TILE_SIZE;


    public static final int TICK_LOCK = 60;
    public static final double ONE_TICK = 1_000_000_000.0 / Config.TICK_LOCK;
    public static final int SECOND = 1_000_000_000;

    public static final int LAYER_MAX = 10;


    public static final int PLAYER_SPEED = 4;


    public static final String pathToImages = "res/images/";
}
