package game;



import renderable.entity.player.Player;
import tilemap.TileMap;
import util.Camera;
import util.Config;
import util.Vector2;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Game extends JFrame {

    private RenderManager rm;
    private TileMap tileMap;

    private InputManager im;

    private Player p;
    private Camera camera;

    public Game() {
        this.im = InputManager.getInstance();
        this.im.addGame(this);

        this.tileMap = new TileMap();


        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.rm = new RenderManager();
        this.rm.addKeyListener(this.im);
        this.rm.setTileMap(this.tileMap);




        this.p = new Player();
        this.p.setDefaultPosition(new Vector2(2, 2));
        this.rm.add(this.p);
        this.im.setMoveable(this.p);

        CollisionsManager cm = CollisionsManager.getInstance();
        cm.addCollidable(this.p);




        Camera.getInstance().setFocus(this.p);




        this.add(this.rm);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public void start() {
        this.gameLoop();
    }

    private void logic() {


        new Thread(() -> InteractionsManager.getInstance().checkDistances(this.p)).start();
        this.p.update();
        Camera.getInstance().update();
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
