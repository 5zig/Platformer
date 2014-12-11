package plattformer.level.entities;

import plattformer.level.Level;

public abstract class Mob extends Entity {

	protected float speed;
	protected int direction;

	private final double GRAVITY = 1000;
	private double yVelocity;

	protected int jumpTimes;
	protected boolean jumpKeyPressed;
	protected boolean canJump;

	public Mob(Level level, int x, int y) {
		super(level, x, y);
		speed = 1;
	}

	public boolean move(int xa, int ya) {
		if (xa > 0) direction = 0;
		if (xa < 0) direction = 1;

		int dirY = 0;
		if (ya > 0) dirY = 0;
		if (ya < 0) dirY = 1;

		int xp = (int) (x + xa * speed);
		int yp = (int) (y + ya * speed);
//		if ((level.getTile((xp >> 4) + 1, y - 1 >> 4).isSolid() && direction == 0) || (level.getTile((xp >> 4) - 1, y - 2 >> 4).isSolid() && direction == 1)) {
////			System.out.println("x");
//			return false;
//		}
		x = xp;
//		if ((onGround() && dirY == 0) || ((level.getTile(x >> 4, (yp >> 4) - 1).isSolid() || level.getTile(x >> 4, (yp >> 4) - 2).isSolid()) && dirY == 1)) {
////			System.out.println("y");
//			return false;
//		}
		y = yp;
		return true;
	}

	protected void jump() {
		yVelocity = 240;
		jumpTimes++;
	}

	@Override
	public void tick() {
		canJump = jumpTimes < 2;

		yVelocity -= GRAVITY * (1.0 / 60.0);
		y -= yVelocity * (1.0 / 60.0);

		if (onGround()) {
			yVelocity = 0;
//			y = terrainHeight;
			jumpKeyPressed = false;
			if (jumpTimes != 0) {
				jumpTimes = 0;
			}
		}


//		move(0, 3);
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

	public boolean onGround() {
		return level.getTile(x >> 4, y >> 4).isSolid();
	}

}