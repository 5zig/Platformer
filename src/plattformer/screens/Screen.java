package plattformer.screens;

import plattformer.Game;

public abstract class Screen {

	protected Game game;
	public int[] pixels;

	public Screen(Game game) {
		this.game = game;
		this.pixels = new int[game.getScaledWidth() * game.getScaledHeight()];
	}

	public abstract void render();

	public void tick() {
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void onKey(int keycode) {
	}

	public void onMouseClick(int x, int y, int button) {
	}

}
