package plattformer.level.tiles;

import plattformer.graphics.Assets;
import plattformer.graphics.Sprite;
import plattformer.screens.Screen;

public class Tile {

	public static final Tile VOID = new Tile(Assets.VOID, false);

	// Tileset: Overworld Level
	public static final Tile GRASS = new Tile(Assets.GRASS, true);
	public static final Tile DIRT = new Tile(Assets.DIRT, true);
	public static final Tile GRASS_LEFT = new Tile(Assets.GRASS_LEFT, false);
	public static final Tile GRASS_RIGHT = new Tile(Assets.GRASS_RIGHT, false);
	public static final Tile DIRT_LEFT = new Tile(Assets.DIRT_LEFT, false);
	public static final Tile DIRT_RIGHT = new Tile(Assets.DIRT_RIGHT, false);
	public static final Tile DIRT_ABOVE = new Tile(Assets.DIRT_ABOVE, false);
	public static final Tile DIRT_ABOVE_LEFT = new Tile(Assets.DIRT_ABOVE_LEFT, false);
	public static final Tile DIRT_ABOVE_RIGHT = new Tile(Assets.DIRT_ABOVE_RIGHT, false);
	public static final Tile DIRTGRASS_LEFT = new Tile(Assets.DIRTGRASS_LEFT, true);
	public static final Tile DIRTGRASS_RIGHT = new Tile(Assets.DIRTGRASS_RIGHT, true);
	public static final Tile DIRTGRASS_BOTH = new Tile(Assets.DIRTGRASS_BOTH, true);
	public static final Tile DIRTGRASS_GAP = new Tile(Assets.DIRTGRASS_GAP, false);
	public static final Tile FLOWER_1 = new Tile(Assets.FLOWER_1, false);
	public static final Tile FLOWER_2 = new Tile(Assets.FLOWER_2, false);
	public static final Tile FLOWER_3 = new Tile(Assets.FLOWER_3, false);
	public static final Tile ISLAND_LEFT = new Tile(Assets.ISLAND_LEFT, true);
	public static final Tile ISLAND_MID = new Tile(Assets.ISLAND_MID, true);
	public static final Tile ISLAND_RIGHT = new Tile(Assets.ISLAND_RIGHT, true);

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
