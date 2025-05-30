package game;

import renderable.entity.Moveable;
import util.Camera;
import util.Vector2;


import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener {
    private Game window;
    private Moveable moveable;

    private static InputManager instance;



    private InputManager() {
    }

    public static InputManager getInstance() {
        if (instance == null) {
            instance = new InputManager();
        }
        return instance;
    }

    public void addGame(Game window) {
        this.window = window;
    }

    public void setMoveable(Moveable m) {
        this.moveable = m;
    }

    public Vector2 mousePosition() {
        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        Point point = pointerInfo.getLocation();
        Point windowLoc = this.window.getLocation();
        int x = point.x - windowLoc.x - 8;
        int y = point.y - windowLoc.y - 32;

        if (x < 0 || x > this.window.getWidth() || y < 0 || y > this.window.getHeight()) {
            return null;
        }
        return new Vector2(x, y);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // ignore
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) {
            this.moveable.right(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            this.moveable.left(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            this.moveable.down(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            this.moveable.up(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            Camera.getInstance().setLocked(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) {
            this.moveable.right(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            this.moveable.left(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            this.moveable.down(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            this.moveable.up(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            Camera.getInstance().setLocked(false);
        }
    }


}
