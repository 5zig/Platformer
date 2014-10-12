package plattformer.screens;

import plattformer.Game;
import plattformer.graphics.Sprite;

public abstract class Screen {
	
	public int xOffset, yOffset;
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

	public void renderSprite(Sprite sprite, int xp, int yp, boolean offset) {
		if (offset) {
			xp -= xOffset;
			yp -= yOffset;
		}
		
		for (int y = 0; y < sprite.getSize(); y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.getSize(); x++) {
				int xa = x + xp;
				if (xa < -sprite.getSize() || xa >= game.getScaledWidth() || ya < 0 || ya >= game.getScaledHeight()) break;
				if (xa < 0) continue;
				int col = sprite.getPixels()[x + y * sprite.getSize()];
				if (col == 0xffff00ff) continue;
				pixels[xa + ya * game.getScaledWidth()] = col;
			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}