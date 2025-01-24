package entity;

public abstract class EntityMovement implements Moveable {
    private double speed;

    private boolean movingRight = false;
    private boolean movingLeft = false;;
    private boolean movingDown = false;
    private boolean movingUp = false;

    private EntityDirection direction = EntityDirection.IDLE;

    public EntityMovement(Entity e) {

    }
}
