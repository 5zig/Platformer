package plattformer.level.entities;

import plattformer.level.Level;
import plattformer.screens.Screen;

import java.awt.*;

public abstract class Entity {

	protected int x, y;
	protected Level level;

	// Hitbox
	protected int hWidth, hHeight;
	protected int hXOffs, hYOffs; // x: left; y: right; (when positive)

	public Entity(Level level, int x, int y) {
		this.x = x;
		this.y = y;
		this.level = level;
		level.entities.add(this);

		hWidth = 16;
		hHeight = 16;
	}

	public abstract void render(Screen screen);

	public void tick() {
	}

	public Rectangle getBounds() {
		return new Rectangle(x - hXOffs, y - hYOffs, hWidth, hHeight);
	}

	public Rectangle getBounds(double x, double y) {
		return new Rectangle((int) x - hXOffs, (int) y - hYOffs, hWidth, hHeight);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
