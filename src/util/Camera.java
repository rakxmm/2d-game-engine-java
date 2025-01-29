package util;

import renderable.Renderable;

public class Camera {

    private static final int SPEED = 1;

    private static final int minX = Config.CANVAS_DIMENSION.width / 2;
    private static final int maxX = Config.MAP_WIDTH - minX;

    private static final int minY = Config.CANVAS_DIMENSION.height / 2;
    private static final int maxY = Config.MAP_HEIGHT - minY;

    /**
     * Vektor znazornuje stredovy bod kamery.
     */
    private static Vector2 position = new Vector2(minX + 100, minY + 100);

    private Camera() {}

    public static void move(Vector2 position) {
        if (position.x() <= Config.CANVAS_DIMENSION.width / 3) {
            if (Camera.position.x() - Camera.SPEED > minX) {
                Camera.position = Camera.position.addX(-Camera.SPEED);
            }
        } else if (position.x() >= Config.CANVAS_DIMENSION.width - Config.CANVAS_DIMENSION.width / 3) {
            if (Camera.position.x() + Camera.SPEED < maxX) {
                Camera.position = Camera.position.addX(Camera.SPEED);
            }
        }

        if (position.y() <= Config.CANVAS_DIMENSION.height / 3) {
            if (Camera.position.y() - Camera.SPEED > minY) {
                Camera.position = Camera.position.addY(-Camera.SPEED);
            }
        } else if (position.y() >= Config.CANVAS_DIMENSION.height - Config.CANVAS_DIMENSION.height / 3) {
            if (Camera.position.y() + Camera.SPEED < maxY) {
                Camera.position = Camera.position.addY(Camera.SPEED);
            }
        }
    }

    public static int offX(Renderable renderable) {
        return renderable.getPosition().x() - Camera.position.x();
    }

    public static int offY(Renderable renderable) {
        return renderable.getPosition().y() - Camera.position.y();
    }

    public static Vector2 getPosition() {
        return new Vector2(Camera.position.x(), Camera.position.y());
    }

}
