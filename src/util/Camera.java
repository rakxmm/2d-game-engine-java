package util;

import game.InputManager;
import renderable.Renderable;
import renderable.entity.CameraLockable;
import renderable.entity.Moveable;
import renderable.entity.player.Player;

import java.awt.*;

public class Camera {



    private static final int MIN_X = 0;
    private static final int MAX_X = Config.MAP_WIDTH;

    private static final int MIN_Y = 0;
    private static final int MAX_Y = Config.MAP_HEIGHT;

    private InputManager im;

    private static Camera instance;

    private boolean locked;

    private CameraLockable cameraLockable;

    /**
     * Vektor znazornuje stredovy bod kamery.
     */
    private Vector2 position = new Vector2(0, 0);

    private Camera() {
    }

    public static Camera getInstance() {
        if (Camera.instance == null) {
            Camera.instance = new Camera();
        }
        return Camera.instance;
    }

    public boolean isLocked() {
        return this.locked;
    }

    public void setFocus(CameraLockable cl) {
        this.cameraLockable = cl;
    }

    public void setLocked(boolean value) {
        if (value && this.cameraLockable == null) {
            return;
        }
        this.locked = value;
    }

    public void setInputManager(InputManager im) {
        this.im = im;
    }

    public void move(Vector2 difference) {
        if (this.position.x() + difference.x() >= 0 && this.position.x() + difference.x() <= MAX_X - Config.WIDTH
                && this.position.y() + difference.y() >= 0 && this.position.y() + difference.y() <= MAX_Y - Config.HEIGHT) {
            this.position = this.position.add(difference);
        }

    }

//    spravit toggle lock

    public void update() {
        if (this.isLocked()) {
            int screenX = Math.max(MIN_X, Math.min(this.cameraLockable.getPosition().x() + Config.TILE_SIZE / 2 - Config.WIDTH / 2, Config.MAP_WIDTH - Config.WIDTH));
            int screenY = Math.max(MIN_Y, Math.min(this.cameraLockable.getPosition().y() + Config.TILE_SIZE / 2 - Config.HEIGHT / 2, Config.MAP_HEIGHT - Config.HEIGHT));

            this.position = new Vector2(screenX, screenY);
        } else {
            if (this.im.mousePosition() != null) {

                if (this.im.mousePosition().x() < Config.WIDTH / 7) {
                    this.move(new Vector2(-Config.CAMERA_SPEED, 0));
                } else if (this.im.mousePosition().x() > Config.WIDTH * 6 / 7) {
                    this.move(new Vector2(Config.CAMERA_SPEED, 0));
                }

                if (this.im.mousePosition().y() < Config.HEIGHT / 7) {
                    this.move(new Vector2(0, -Config.CAMERA_SPEED));
                } else if (this.im.mousePosition().y() > Config.HEIGHT * 6 / 7) {
                    this.move(new Vector2(0, Config.CAMERA_SPEED));
                }
            }
        }
    }


    public Vector2 getPosition() {
        return this.position;
    }

}
