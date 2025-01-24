package game;

import entity.player.Player;
import tile.TileMap;
import util.Config;
import util.InputManager;

public class Game {

    private final RenderManager renderManager;
    private final Window window;

    private final TileMap tileMap;
    private final Player player;
    private final InputManager inputManager;

    public Game() {
        this.window = new Window();
        this.renderManager = new RenderManager();
        this.inputManager = new InputManager();
        this.renderManager.addKeyListener(this.inputManager);

        this.tileMap = new TileMap();
        this.player = new Player();
        this.player.addInputManager(this.inputManager);



        this.renderManager.add(this.player);
        this.renderManager.add(this.tileMap);


        this.window.add(this.renderManager);



        this.window.pack();
        this.window.setLocationRelativeTo(null);
        this.window.setVisible(true);
    }

    public void start() {
        this.gameLoop();
    }

    private void logic() {
        this.player.move();
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
            this.renderManager.render();

            lastTime = currentTime;
        }
    }

    public static void main(String[] args) {
        new Game().start();
    }



}
