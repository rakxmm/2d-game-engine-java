package entity;

import util.InputManager;

public interface Moveable {
    void setSpeed(double speed);

    double speed();

    void move();

    void setDirection(EntityDirection direction);

    EntityDirection direction();

    void addInputManager(InputManager inputManager);
}
