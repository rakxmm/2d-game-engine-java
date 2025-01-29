package game;

import util.Camera;
import util.Config;
import util.Vector2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InputManager extends MouseAdapter {
    private Game game;

    public InputManager(Game game) {
        this.game = game;
    }

//    @Override
//    public void keyPressed(KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_D) {
//            Camera.move(Camera.getPosition().add(new Vector2(2, 0)));
//        }
//        if (e.getKeyCode() == KeyEvent.VK_A) {
//            Camera.move(Camera.getPosition().add(new Vector2(-2, 0)));
//        }
//    }

    @Override
    public void mouseMoved(MouseEvent e) {

        if ((e.getX() < Config.CANVAS_DIMENSION.width / 3)
                || (e.getX() > Config.CANVAS_DIMENSION.width - Config.CANVAS_DIMENSION.width / 3)
                || (e.getY() < Config.CANVAS_DIMENSION.height / 3)
                || (e.getY() > Config.CANVAS_DIMENSION.height - Config.CANVAS_DIMENSION.height / 3)) {
            Camera.move(new Vector2(e.getX(), e.getY()));
        }
    }


}
