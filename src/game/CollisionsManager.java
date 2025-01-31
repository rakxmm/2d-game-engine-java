package game;

import renderable.Collidable;
import renderable.CollidableState;
import util.Vector2;

import java.util.ArrayList;
import java.util.List;

public class CollisionsManager {
    private List<Collidable> collidableList;

    private static CollisionsManager instance;

    private CollisionsManager() {
        this.collidableList = new ArrayList<>();
    }

    public static CollisionsManager getInstance() {
        if (CollisionsManager.instance == null) {
            CollisionsManager.instance = new CollisionsManager();
        }
        return CollisionsManager.instance;
    }

    public void addCollidable(Collidable c) {
        if (!this.collidableList.contains(c)) {
            this.collidableList.add(c);
        }
    }

    public boolean canMove(Collidable collidable, Vector2 newPosition) {
        for (Collidable c : this.collidableList) {
            if (c.equals(collidable)) {
                continue;
            }
            if (c.collide(collidable, newPosition) && c.getState() == CollidableState.SOLID) {
                return false;
            }
        }
        return true;
    }

}
