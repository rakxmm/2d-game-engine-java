package game;


import tilemap.TileMap;
import util.Config;

import javax.swing.*;

public class Game extends JFrame {

    private RenderManager rm;
    private InputManager im;
    private TileMap tileMap;

    public Game() {
        this.im = new InputManager(this);
        this.tileMap = new TileMap();


        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.rm = new RenderManager();
        this.rm.addMouseMotionListener(this.im);
        this.rm.setTileMap(this.tileMap);
        this.add(rm);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public void start() {
        this.gameLoop();
    }

    private void logic() {
        this.tileMap.update();
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


            while (deltaTime >= Config.TICK) {
                deltaTime -= Config.TICK;
                ticks++;
                this.logic();

            }


            if (timer >= 1_000_000_000) {
                FPSCounter.update();
                FPSCounter.reset();
                ticks = 0;
                timer -= 1_000_000_000;
            }

            FPSCounter.add();
            this.rm.render();


            lastTime = currentTime;


        }
    }

    public static void main(String[] args) {
        new Game().start();
    }



}
