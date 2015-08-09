package plattformer.level;

import plattformer.Game;
import plattformer.level.tiles.Tileset;

public class SpawnLevel extends Level {

	private final String path = "/levels/level1.lvl";

	public SpawnLevel(Game game) {
		super(game, Tileset.OVERWORLD_LEVEL);
		loadLevel(path);
	}
}
