package renderable;

import renderable.entity.Entity;

public interface Interactable {

    void handleInteraction(Entity e);

    boolean inDistance(Entity e);
}
