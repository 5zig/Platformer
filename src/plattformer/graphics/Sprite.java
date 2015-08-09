package plattformer.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Sprite {

    private int[] pixels;
    private int width, height;

    /**
     * Extract a sprite from the spritesheet with specific coordinates
     *
     * @param sheet Spritesheet
     * @param x     X-Coordinate
     * @param y     Y-Coordinate
     * @param size  The Size of the Sprite
     */
    public Sprite(SpriteSheet sheet, int x, int y, int size) {
        pixels = new int[size * size];
        width = size;
        height = size;

        for (int yy = 0; yy < size; yy++) {
            int yo = y * size + yy;
            for (int xx = 0; xx < size; xx++) {
                int xo = x * size + xx;
                pixels[xx + yy * size] = sheet.getPixels()[xo + yo * sheet.getWidth()];
            }
        }
    }

    public Sprite(String path) {
        System.out.print("Trying to load Sprite from " + path + "... ");
        try {
            BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
            width = image.getWidth();
            height = image.getHeight();
            pixels = new int[width * height];
            image.getRGB(0, 0, width, height, pixels, 0, width > height ? width : height);
            System.out.println("done.");
        } catch (IOException e) {
            System.out.println("failed.");
            e.printStackTrace();
        }
    }

    public Sprite(int col, int size) {
        width = size;
        height = size;
        pixels = new int[size * size];

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = col;
        }
    }

    public int[] getPixels() {
        return pixels;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}