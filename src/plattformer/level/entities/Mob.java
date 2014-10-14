package plattformer.level.entities;

import plattformer.level.Level;
import plattformer.util.Vector2f;

public abstract class Mob extends Entity {

	protected float speed;
	protected int direction;
	protected float motX = 0, motY = 0;

	public Mob(Level level, int x, int y) {
		super(level, x, y);
		speed = 1;
	}

	public boolean move(int xa, int ya) {
		if (xa > 0) direction = 0;
		if (xa < 0) direction = 1;

		int xp = (int) (x + xa * speed);
		int yp = (int) (y + ya * speed);
		if (level.getTile(xp >> 4, y >> 4).isSolid()) return false;
		x = xp;
		if (level.getTile(x >> 4, yp >> 4).isSolid()) return false;
		y = yp;
		return true;
	}

	@Override
	public void tick() {
		updateVelocity();
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
	
	public void setVelocity(Vector2f vec2f) {
		this.motX = vec2f.getX();
		this.motY = vec2f.getY();
	}

	public boolean hasVelocity() {
		return motX != 0 || motY != 0;
	}

	public boolean onGround() {
		return level.getTile(x >> 4, y + 1 >> 4).isSolid();
	}

	private void updateVelocity() {
		boolean moved = true;
		if (motX != 0 || motY != 0) moved = move((int) -(motX * 2), (int) -(motY * 2));

		if (motX != 0) motX -= 0.2;
		if (motY != 0) motY -= 0.2;
		else motY = -0.2f;

		if (onGround()) {
			motX = 0.0f;
			motY = 0.0f;
			return;
		}

		if (!moved) {
			motX = (motX != 0) ? -0.2f : 0.0f;
			motY = (motY != 0) ? -0.2f : 0.0f;
		}

		// System.out.println(motX + ", " + motY);

	}
}