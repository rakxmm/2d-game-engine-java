package game;

public class FPSCounter {
    private static int currentFps = 0;
    private static int fpsToSend;

    private FPSCounter() {

    }

    public static void add() {
        FPSCounter.currentFps++;
    }

    public static void reset() {
        FPSCounter.currentFps = 0;
    }

    public static void update() {
        FPSCounter.fpsToSend = FPSCounter.currentFps;
    }

    public static int get() {
        return FPSCounter.fpsToSend;
    }

}
