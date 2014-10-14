package plattformer.level.entities;

import plattformer.level.Level;

public abstract class Mob extends Entity {
	
	protected float speed;
	protected int direction;
	
	public Mob(Level level, int x, int y) {
		super(level, x, y);
		speed = 1;
	}
	
	public void move(int xa, int ya) {
		if (xa > 0) direction = 0;
		if (xa < 0) direction = 1;
		
		x += xa * speed;
		y += ya * speed;
	}
	
	public boolean collision() {
		/* Soon */
		return false;
	}
	
	public float getSpeed() {
		return speed;
	}
	
	public int getDirection() {
		return direction;
	}
}