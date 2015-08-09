package plattformer.level.tiles;

import plattformer.graphics.Assets;
import plattformer.graphics.Sprite;
import plattformer.screens.Screen;

public class Tile {

	// Tileset: Overworld Level
	public static final Tile GRASS = new Tile(Assets.GRASS, true);
	public static final Tile GRASS_LEFT = new Tile(Assets.GRASS_LEFT, false);
	public static final Tile GRASS_RIGHT = new Tile(Assets.GRASS_RIGHT, false);
	public static final Tile DIRT = new Tile(Assets.DIRT, true);
	public static final Tile VOID = new Tile(Assets.VOID, false);

	private Sprite sprite;
	private boolean solid;

	public Tile(Sprite sprite, boolean solid) {
		this.sprite = sprite;
		this.solid = solid;
	}

	public void render(Screen screen, int xp, int yp) {
		screen.renderSprite(sprite, xp << 4, yp << 4, 0, true);
	}

	public Sprite getSprite() {
		return sprite;
	}

	public boolean isSolid() {
		return solid;
	}

}
