package game;

import tile.TileMap;
import util.Config;

import java.text.CompactNumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private final RenderManager rm;
    private final Window w;

    private final TileMap tileMap;


    public Game() {
        this.tileMap = new TileMap();

        this.rm = new RenderManager();
        this.rm.addRenderable(this.tileMap.getMap());
        this.w = new Window();

        this.w.add(this.rm);
        this.w.pack();
        this.w.setLocationRelativeTo(null);
        this.w.setVisible(true);
    }

    public void start() {
        this.gameLoop();
    }

    private void logic() {

    }

    private void gameLoop() {
        long lastTime = System.nanoTime();
        double deltaTime = 0;
        double timer = 0;

        int fps = 0;
        int ticks = 0;

        while (true) {
            long currentTime = System.nanoTime();
            deltaTime += currentTime - lastTime;
            timer += currentTime - lastTime;

            while (deltaTime >= Config.ONE_TICK) {
                deltaTime -= Config.ONE_TICK;
                ticks++;
                this.logic();
            }




            if (timer >= Config.SECOND) {
                System.out.println("FPS: " + fps + " || TICKS: " + ticks);
                fps = 0;
                ticks = 0;
                timer -= Config.SECOND;
            }

            fps++;
            this.rm.render();

            lastTime = currentTime;






        }
    }


    public static void main(String[] args) {
        new Game().start();
    }



}
