package plattformer.level.entities;

import plattformer.level.Level;
import plattformer.screens.Screen;

import java.awt.*;

public abstract class Entity {

	protected int x, y;
	protected Level level;

	public Entity(Level level, int x, int y) {
		this.x = x;
		this.y = y;
		this.level = level;
		level.entities.add(this);
	}

	public abstract void render(Screen screen);

	public void tick() {
	}

	public abstract Rectangle getBounds();

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
