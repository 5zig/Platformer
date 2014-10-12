package plattformer.level.entities;

import plattformer.level.Level;
import plattformer.screens.Screen;

public abstract class Entity {

	protected int x, y;

	public Entity(Level level, int x, int y) {
		this.x = x;
		this.y = y;
		level.entities.add(this);
	}

	public abstract void render(Screen screen);

	public void tick() {
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
