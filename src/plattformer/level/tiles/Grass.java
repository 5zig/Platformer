package plattformer.level.tiles;

import plattformer.graphics.Sprite;

public class Grass extends Tile {

	public Grass(Sprite sprite) {
		super(sprite);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}