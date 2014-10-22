package plattformer.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import plattformer.Game;

public class SpawnLevel extends Level {

	private final String path = "/levels/spawn.png";

	public SpawnLevel(Game game) {
		super(game);
	}

	@Override
	protected void loadLevel() {
		System.out.print("Trying to load Spritesheet from " + path + "... ");
		try {
            BufferedImage image = ImageIO.read(getClass().getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			tiles = new int[width * height];
			image.getRGB(0, 0, width, height, tiles, 0, width > height ? width : height);
			System.out.println("done.");
		} catch (IOException e) {
			System.out.println("failed.");
			e.printStackTrace();
		}
	}

}
