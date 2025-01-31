package renderable.imageloader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImageLoader {

    private static final Map<String, BufferedImage> IMAGE_MAP = new HashMap<>();

    private ImageLoader() {
    }

    private static void loadImage(String fileName) {
        try {
            BufferedImage img = ImageIO.read(new File("res/images/" + fileName));
            ImageLoader.IMAGE_MAP.put(fileName, img);
        } catch (IOException e) {
            System.out.println("Failed to load an image!");;
        }
    }

    public static BufferedImage getImage(String fileName) {
        if (ImageLoader.IMAGE_MAP.get(fileName) == null) {
            ImageLoader.loadImage(fileName);
        }

        return ImageLoader.IMAGE_MAP.get(fileName);
    }
}
