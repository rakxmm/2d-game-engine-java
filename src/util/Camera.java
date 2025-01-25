package util;

import entity.player.Player;
import tile.Tile;

public class Camera {

    private int playerOffsetX;
    private int playerOffsetY;

    private Player player;

    public void addPlayer(Player p) {
        this.player = p;
    }

    public Vector2 getPlayerOffset() {
        double x = this.player.position().x() - ((double)(Config.WINDOW_WIDTH) / 2);
        double y = this.player.position().y() - ((double)(Config.WINDOW_HEIGHT) / 2);
        System.out.println("x: " + x + " y: " + y);

        return new Vector2(x, y);
    }

    public Vector2 getDistanceFromPlayer(Tile tile) {
        double x = this.player.position().x() - tile.position().x();
        double y = this.player.position().y() - tile.position().y();
//        System.out.println("x: " + x + " y: " + y);
        return new Vector2(x, y);
    }
}
