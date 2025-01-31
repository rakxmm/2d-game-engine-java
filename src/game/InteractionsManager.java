package game;

import renderable.Interactable;

public class InteractionsManager {

    private static InteractionsManager instance;

    private InteractionsManager() {
    }


    public static InteractionsManager getInstance() {
        if (InteractionsManager.instance == null) {
            InteractionsManager.instance = new InteractionsManager();
        }
        return InteractionsManager.instance;
    }

    public void addInteractable(Interactable i) {

    }
}
