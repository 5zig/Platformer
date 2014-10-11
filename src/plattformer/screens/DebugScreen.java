package plattformer.screens;

import java.util.Random;

import plattformer.Game;
import plattformer.graphics.Sprite;

public class DebugScreen extends Screen {

	private final Random r = new Random();

	public DebugScreen(Game game) {
		super(game);
	}

	private int ticks, x; // Only temporarily

	@Override
	public void tick() {
		ticks++;
		if (x + game.getScaledWidth() * 16 + 16 < pixels.length) x += 1;
		else x = 0;
	}

	@Override
	public void render() {
		// pixels[r.nextInt(pixels.length)] = 0xffffff;
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = i + ticks;
		}
		Sprite sprite = Sprite.TEST;
		for (int y = 0; y < sprite.getSize(); y++) {
			for (int x = 0; x < sprite.getSize(); x++) {
				pixels[(this.x + x) + y * game.getScaledWidth()] = sprite.getPixels()[x + y * sprite.getSize()];
			}
		}
	}

	@Override
	public void onKey(int keycode) {
		System.out.println("key: " + keycode);
	}

	@Override
	public void onMouseClick(int x, int y, int button) {
		System.out.println("mouse: " + button + " - " + x + ", " + y);
	}

}
