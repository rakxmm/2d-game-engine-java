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




    public double getPlayerOffsetX() {
        if (this.player.position().x() < (double)Config.WINDOW_WIDTH / 2) {
            return 0;
        } else if (this.player.position().x() + (double)Config.WINDOW_WIDTH / 2  >  Config.SCREEN_MAX_W) {
            return Config.SCREEN_MAX_W - Config.WINDOW_WIDTH;
        }
        return this.player.position().x() - ((double)Config.WINDOW_WIDTH / 2);
    }




    public double getPlayerOffsetY() {

        if (this.player.position().y() < (double)Config.WINDOW_HEIGHT / 2) {
            return 0;
        } else if (this.player.position().y() + (double)Config.WINDOW_HEIGHT / 2 > Config.SCREEN_MAX_H) {
            return Config.SCREEN_MAX_H - Config.WINDOW_HEIGHT;
        }
        return this.player.position().y() - ((double)Config.WINDOW_HEIGHT / 2);
    }



    /**
     * Vrati vzdialenost hraca od danej dlazdice.
     * @param tile Tile, dlazdica, od ktorej ratame vzdialenost.
     * @return Vector2, vzdialenost dvojrozmerny vektor.
     */
    public Vector2 getDistancePlayerTile(Tile tile) {
        double x = this.player.position().x() - tile.position().x();
        double y = this.player.position().y() - tile.position().y();
        return new Vector2(x, y);
    }


}
