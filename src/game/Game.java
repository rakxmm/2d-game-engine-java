package game;


import entity.player.Player;
import tile.TileMap;
import util.Camera;
import util.Config;
import util.InputManager;


public class Game {

    private final RenderManager renderManager;
    private final Window window;

    private final TileMap tileMap;
    private final Player player;

    private final InputManager inputManager;

    private final Camera camera;

    public Game() {
        this.window = new Window();
        this.inputManager = new InputManager();

        this.camera = new Camera();



        this.renderManager = new RenderManager();
        this.renderManager.addKeyListener(this.inputManager);

        this.player = new Player();
        this.player.addCamera(this.camera);
        this.camera.addPlayer(this.player);

        this.tileMap = new TileMap();
        this.tileMap.addCamera(this.camera);
        this.tileMap.loadMap();
        this.tileMap.update();



        this.inputManager.addMoveable(this.player);


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
        if (this.player.move()) {
            this.tileMap.update();
        }
    }

    private void gameLoop() {
        long lastTime = System.nanoTime();
        double deltaTime = 0;
        double timer = 0;
        double animationTimer = 0;



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

            if (this.player.isMoving()) {
                animationTimer += currentTime - lastTime;
                if (animationTimer >= (double)Config.SECOND / 6) {
                    this.player.updateFrame();
                    animationTimer -= (double)Config.SECOND / 6;
                }
            }


            fps++;
            this.renderManager.render();

            lastTime = currentTime;

//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }

        }
    }

    public static void main(String[] args) {
        new Game().start();
    }



}
