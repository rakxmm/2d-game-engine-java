package util;

public class Config {

    public static final int TILE_SCALE = 2;
    public static final int DEFAULT_TILE_SIZE = 16;

    public static final int TILE_SIZE = DEFAULT_TILE_SIZE * TILE_SCALE;
    public static final int WINDOW_WIDTH = 1280;
    public static final int WINDOW_HEIGHT = 720;

    public static final int TILES_PER_WIDTH = Config.WINDOW_WIDTH / Config.TILE_SIZE;
    public static final int TILES_PER_HEIGHT = Config.WINDOW_HEIGHT / Config.TILE_SIZE;

    public static final int TICK_LOCK = 60;
    public static final double ONE_TICK = 1_000_000_000.0 / Config.TICK_LOCK;
    public static final int SECOND = 1_000_000_000;

    public static final int LAYER_MAX = 10;
}
