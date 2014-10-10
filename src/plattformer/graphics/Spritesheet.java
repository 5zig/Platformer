package plattformer.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {

	private String path;
	private int width, height;
	private int[] pixels;

	public Spritesheet(String path) {
		load();
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	private void load() {
		System.out.print("Trying to load Spritesheet from " + path + "...");
		try {
			BufferedImage image = ImageIO.read(Spritesheet.class.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			pixels = new int[width * height];
			image.getRGB(0, 0, width, height, pixels, 0, width > height ? width : height);
			System.out.println("done.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("failed.");
		}
	}

}
