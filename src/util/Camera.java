package util;

import renderable.Renderable;
import renderable.entity.player.Player;

import java.awt.*;

public class Camera {



    private static final int minX = Config.CANVAS_DIMENSION.width / 2;
    private static final int maxX = Config.MAP_WIDTH - minX;

    private static final int minY = Config.CANVAS_DIMENSION.height / 2;
    private static final int maxY = Config.MAP_HEIGHT - minY;

    private static Player player;

    /**
     * Vektor znazornuje stredovy bod kamery.
     */
    private static Vector2 position = new Vector2(minX, minY);

    private Camera() {}

    public static void move(Vector2 difference) {

        if (Camera.position.x() + difference.x() >= 0
                && Camera.position.x() + difference.x() <= maxX - minX
                && Camera.position.y() + difference.y() >= 0
                && Camera.position.y() + difference.y() <= maxY - minY) {
            Camera.position = Camera.position.add(difference);
        }
    }

    public static void render(Graphics2D g) {
        g.setColor(Color.blue);
        g.fillRect(Config.CANVAS_DIMENSION.width / 2 - 10, Config.CANVAS_DIMENSION.height / 2 - 10, 20, 20);
    }

    public static void lock(Player player) {
        Camera.player = player;
        Camera.position = Camera.player.getPosition();
    }


    public static Vector2 getPosition() {
        return new Vector2(Camera.position.x(), Camera.position.y());
    }

    public static boolean isLocked() {
        return Camera.player != null;
    }

    public static void update() {
        if (Camera.isLocked()) {
            if ((Camera.player.getPosition().x() > minX
                    && Camera.player.getPosition().x() < maxX
                    && Camera.player.getPosition().y() > minY
                    && Camera.player.getPosition().y() < maxY )) {

                Camera.position = Camera.player.getPosition().diff(new Vector2( Config.CANVAS_DIMENSION.width / 2 - Config.TILE_SIZE / 2,
                        Config.CANVAS_DIMENSION.height / 2 - Config.TILE_SIZE / 2));
            }

        }
    }

}
