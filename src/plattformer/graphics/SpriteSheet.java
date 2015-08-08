package plattformer.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {

	private String path;
	private int width, height;
	private int[] pixels;

	public static final SpriteSheet TEST = new SpriteSheet("/test.png");
	public static final SpriteSheet PLAYER = new SpriteSheet("/entities/player.png");

	public SpriteSheet(String path) {
		this.path = path;
		load();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int[] getPixels() {
		return pixels;
	}

	private void load() {
		System.out.print("Trying to load Spritesheet from " + path + "... ");
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
}