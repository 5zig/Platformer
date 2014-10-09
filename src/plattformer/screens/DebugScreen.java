package plattformer.screens;

import java.util.Random;

import plattformer.Game;

public class DebugScreen extends Screen {

	private final Random r = new Random();

	public DebugScreen(Game game) {
		super(game);
	}

	@Override
	public void render() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = r.nextInt();
		}
	}

}
