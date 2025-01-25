package util;

import entity.Moveable;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class InputManager extends KeyAdapter {
    private final List<Moveable> moveables;



    public InputManager() {
        this.moveables = new ArrayList<>();
    }



    public void addMoveable(Moveable moveable) {
        this.moveables.add(moveable);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        for (Moveable m : this.moveables) {
            if (e.getKeyCode() == KeyEvent.VK_S) {
                m.down(true);
            } else if (e.getKeyCode() == KeyEvent.VK_W) {
                m.up(true);
            } else if (e.getKeyCode() == KeyEvent.VK_D) {
                m.right(true);
            } else if (e.getKeyCode() == KeyEvent.VK_A) {
                m.left(true);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        for (Moveable m : this.moveables) {
            if (e.getKeyCode() == KeyEvent.VK_S) {
                m.down(false);
            } else if (e.getKeyCode() == KeyEvent.VK_W) {
                m.up(false);
            } else if (e.getKeyCode() == KeyEvent.VK_D) {
                m.right(false);
            } else if (e.getKeyCode() == KeyEvent.VK_A) {
                m.left(false);
            }
        }
    }
}
