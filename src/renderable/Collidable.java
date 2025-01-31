package renderable;

import util.Vector2;


public interface Collidable {

    boolean collide(Collidable collidable, Vector2 possiblePosition);

    Vector2 getPosition();

    Vector2 getSize();

    CollidableState getState();
}
