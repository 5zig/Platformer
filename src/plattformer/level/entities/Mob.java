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

		/*int dirY = 0;
		if (ya > 0) dirY = 0;
		if (ya < 0) dirY = 1;
		System.out.println(dirY);*/
		
		if (!collision(xa, ya)) {
			x += xa * speed;
			y += ya * speed;
		}
/*		if ((level.getTile((xp >> 4) + 1, y - 1 >> 4).isSolid() && direction == 0) || (level.getTile((xp >> 4) - 1, y - 2 >> 4).isSolid() && direction == 1)) {
			System.out.println("x");
			return false;
		}
		x = xp;
		if ((onGround() && dirY == 0) || ((level.getTile(x >> 4, (yp >> 4) - 1).isSolid() || level.getTile(x >> 4, (yp >> 4) - 2).isSolid()) && dirY == 1)) {
			System.out.println("y");
			return false;
		}
		y = yp;*/
		return true;
	}

	@Override
	public void tick() {
		if (!hasVelocity() && !onGround()) {
			move(0, 3);
		}
		updateVelocity();
	}

	public boolean collision(int xa, int ya) {
		return level.getTile((x + xa) / 16, (y + ya) / 16).isSolid();
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
		moved = move(-(int) (motX * 6), -(int) (motY * 6));

		if (motX > 0) motX -= 0.2;
		else motX = 0;
		if (motY > 0) motY -= 0.2;
		else motY = 0;

		if (!moved || onGround()) {
			motX = 0.0f;
			motY = 0.0f;
			return;
		}

//		System.out.println(motY);
	}
}