package plattformer.level.tiles;

import plattformer.graphics.Sprite;

public class Void extends Tile {

	public Void(Sprite sprite) {
		super(sprite);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
