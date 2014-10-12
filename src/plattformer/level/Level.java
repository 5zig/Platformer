package plattformer.level;

import plattformer.Game;
import plattformer.level.tiles.Tile;

public class Level {

	private Game game;
	private int width, height;

	private int[] tiles;

	public Level(Game game) {
		this.game = game;
	}

	public void render() {
	}

	public void update() {
	}

	public Tile getTile(int x, int y) {
		return null;
	}

}