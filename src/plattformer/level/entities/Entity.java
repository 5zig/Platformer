package plattformer.level.entities;

import plattformer.level.Level;

public class Entity {

	protected int x, y;
	
	public Entity(Level level, int x, int y) {
		this.x = x;
		this.y = y;
		// TODO: add to level
	}
	
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
