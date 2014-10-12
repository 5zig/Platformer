package plattformer.screens;

import java.util.Random;

import plattformer.Game;
import plattformer.graphics.Sprite;

public class DebugScreen extends Screen {

	private final Random r = new Random();

	public DebugScreen(Game game) {
		super(game);
	}

	private int ticks;
	private int x = r.nextInt(game.getScaledWidth()), y = 0;

	@Override
	public void tick() {
		ticks++;
		x += r.nextInt(2);
		y += r.nextInt(2);
		
		if (x < -0 || y < 0 || x >= game.getScaledWidth() || y >= game.getScaledHeight()) {
			x = r.nextInt(game.getScaledWidth());
			y = 0;
		}
	}

	@Override
	public void render() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = i + ticks;
		}

		renderSprite(Sprite.TESTSPRITE, x, y, false);
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