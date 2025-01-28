package game;


import util.Config;

import javax.swing.*;

public class Game extends JFrame {

    private RenderManager rm;

    public Game() {

        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.rm = new RenderManager();
        this.add(rm);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

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


            while (deltaTime >= Config.TICK) {
                deltaTime -= Config.TICK;
                ticks++;
                this.logic();

            }


            if (timer >= 1_000_000_000) {
                System.out.println("FPS: " + fps + " || TICKS: " + ticks);
                fps = 0;
                ticks = 0;
                timer -= 1_000_000_000;
            }


            this.rm.render();
            fps++;

            lastTime = currentTime;
        }
    }

    public static void main(String[] args) {
        new Game().start();
    }



}
