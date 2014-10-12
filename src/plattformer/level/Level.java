package plattformer.level;

import plattformer.Game;
import plattformer.level.tiles.Tile;

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

	public void render() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				getTile(x, y).render(game.getCurrentScreen(), x, y);
			}
		}
	}

	public void update() {
	}

	public Tile getTile(int x, int y) {
		if (tiles[x + y * width] == Tile.COL_GRASS) return Tile.GRASS;
		return Tile.VOID;
	}

}