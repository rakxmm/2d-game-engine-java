package entity.player;

import entity.Entity;
import entity.EntityDirection;
import entity.Moveable;
import util.InputManager;
import util.Vector2;

public class Player extends Entity {
    private EntityDirection direction;
    private InputManager inputManager;

    public Player() {
        this.setLayer(1);
        this.setImage("character_16x16.png");
        this.setPosition(new Vector2(10, 10));

    }








}
