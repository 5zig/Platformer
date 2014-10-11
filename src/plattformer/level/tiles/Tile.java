package plattformer.level.tiles;

import plattformer.graphics.Sprite;
import plattformer.screens.Screen;

public abstract class Tile {

	private Sprite sprite;
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(Screen screen, int xp, int yp) {
		screen.renderSprite(sprite, xp, yp);
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public boolean isSolid() {
		return true;
	}
	
}
