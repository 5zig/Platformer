package plattformer.level;

import plattformer.Game;
import plattformer.level.tiles.Tile;
import plattformer.screens.Screen;

public class Level {

	private Game game;
	protected int width, height;

	protected int[] tiles;

	public Level(Game game) {
		this.game = game;
		loadLevel();
	}

	protected void loadLevel() {
	}

	public void render(Screen screen, int xScroll, int yScroll) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll;
		int x1 = xScroll + game.getScaledWidth();
		int y0 = yScroll;
		int y1 = yScroll + game.getScaledHeight();
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(screen, x, y);
			}
		}
	}

	public void tick() {
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || x >= width || y < 0 || y >= height) return Tile.GRASS;
		if (tiles[x + y * width] == Tile.COL_GRASS) return Tile.GRASS;
		return Tile.VOID;
	}
}