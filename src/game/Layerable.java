package game;

public interface Layerable extends Comparable<Layerable> {
    void setLayer(int layer);

    int layer();
}
