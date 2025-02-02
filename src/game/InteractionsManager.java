package game;

import renderable.Interactable;
import renderable.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class InteractionsManager {

    private static InteractionsManager instance;

    private List<Interactable> interactableList;

    private InteractionsManager() {
        this.interactableList = new ArrayList<>();
    }


    public static InteractionsManager getInstance() {
        if (InteractionsManager.instance == null) {
            InteractionsManager.instance = new InteractionsManager();
        }
        return InteractionsManager.instance;
    }

    public void addInteractable(Interactable i) {
        if (!this.interactableList.contains(i)) {
            this.interactableList.add(i);
        }
    }

    public void checkDistances(Entity entity) {
        for (Interactable i : this.interactableList) {
            if (i.inDistance(entity)) {
                i.handleInteraction(entity);
            }

        }
    }
}
