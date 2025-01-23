package entity;

import game.Renderable;
import util.Vector2;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity extends Renderable {
    private Vector2 position;

    public abstract void move(Vector2 howMuch);

    public void setPosition(Vector2 position) {
        this.position = position;
    }
    public Vector2 position() {
        return this.position;
    }


}
