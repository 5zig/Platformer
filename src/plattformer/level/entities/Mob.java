package plattformer.level.entities;

import plattformer.level.Level;
import plattformer.util.Vector2f;

public abstract class Mob extends Entity {

	protected float speed;
	protected int direction;
	protected float motX = 0, motY = 0;
	protected float fallDistance = 0;

	public Mob(Level level, int x, int y) {
		super(level, x, y);
		speed = 1;
	}

	public void move(int xa, int ya) {
		if (xa > 0) direction = 0;
		if (xa < 0) direction = 1;

		int dirY = 0;
		if (ya > 0) dirY = 0;
		if (ya < 0) dirY = 1;

		int xp = (int) (x + xa * speed);
		int yp = (int) (y + ya * speed);

		while (xa != 0) {
			if (Math.abs(xa) > 1) {
				if (!collision(abs(xa), (int) ya)) {
					this.x += abs(xa);
				}
				xa -= abs(xa);
			} else {
				if (!collision(abs(xa), (int) ya)) {
					this.x += xa;
				}
				xa = 0;
			}
		}

		while (ya != 0) {
			if (Math.abs(ya) > 1) {
				if (!collision((int) xa, abs(ya))) {
					this.y += abs(ya);
				}
				ya -= abs(ya);
			} else {
				if (!collision((int) xa, abs(ya))) {
					this.y += ya;
				}
				ya = 0;
			}
		}
	}

	private int abs(double value) {
		if (value < 0) return -1;
		return 1;
	}

	@Override
	public void tick() {
		if (!hasVelocity() && !onGround()) {
			motY = -1;
			fallDistance += 1;
		}
		if (motY <= -1 && fallDistance > 0) {
			fallDistance += 1.0 / 16.0;
			motY *= 1.7;
		}
		if (fallDistance > 0) System.out.println(fallDistance);
		updateVelocity();
	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			double xt = ((x + xa) - c % 2 * 16) / 16;
			double yt = ((y + ya) - c / 2 * 16) / 16;
			int ix = (int) Math.ceil(xt);
			int iy = (int) Math.ceil(yt);
			if (level.getTile(ix, iy).isSolid()) solid = true;
		}
		return solid;
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
		move(-(int) (motX * 4), -(int) (motY * 4));

		if (motX > 0) motX -= 0.2;
		else motX = 0;
		if (motY > 0) motY -= 0.2;
		else motY = 0;

		if (onGround()) fallDistance = 0;

		if (onGround()) {
			motX = 0.0f;
			motY = 0.0f;
			return;
		}

		// System.out.println(motY);
	}
}