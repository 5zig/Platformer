package plattformer.level.entities;

import plattformer.level.Level;

public abstract class Mob extends Entity {

	protected double dx, dy;

	protected int direction;

	protected boolean left, right;
	protected boolean jumping;
	protected boolean airborne;

	protected double movementSpeed = 0.3;
	protected double maxMovementSpeed = 3.0;
	protected double maxFallingSpeed = 6;
	protected double stopMovementSpeed = 0.3;
	protected double jumpMomentum = -6;
	protected double gravity = 0.3;

	// Collision variables
	protected boolean topLeft;
	protected boolean topRight;
	protected boolean bottomLeft;
	protected boolean bottomRight;

	public Mob(Level level, int x, int y) {
		super(level, x, y);
	}

	protected void jump() {
		if (!airborne)
			jumping = true;
	}

	@Override
	public void tick() {
		if (left) {
			direction = 1;
			dx -= movementSpeed;
			if (dx < -maxMovementSpeed) {
				dx = -maxMovementSpeed;
			}
		} else if (right) {
			direction = 0;
			dx += movementSpeed;
			if (dx > maxMovementSpeed) {
				dx = maxMovementSpeed;
			}
		} else {
			if (dx > 0) {
				dx -= stopMovementSpeed;
				if (dx < 0) {
					dx = 0;
				}
			}
			if (dx < 0) {
				dx += stopMovementSpeed;
				if (dx > 0) {
					dx = 0;
				}
			}
		}

		if (jumping) {
			dy = jumpMomentum;
			airborne = true;
			jumping = false;
		}

		if (airborne) {
			dy += gravity;
			if (dy > maxFallingSpeed) {
				dy = maxFallingSpeed;
			}
		} else {
			dy = 0;
		}

		// Collision Detection

		int col = x >> 4;
		int row = y >> 4;

		double tempX = x;
		double tempY = y;

		// Foreseeing the future positions!
		double toX = x + dx;
		double toY = y + dy;

		checkCollision(x, toY);
		if (dy < 0) {
			if (topLeft || topRight) {
				dy = 0;
				tempY = (row << 4) + getBounds().getHeight() / 2;
			} else {
				tempY += dy;
			}
		}
		if (dy > 0) {
			if (bottomLeft || bottomRight) {
				dy = 0;
				airborne = false;
				tempY = (row + 1 << 4) - getBounds().getHeight() / 2;
			} else {
				tempY += dy;
			}
		}

		checkCollision(toX, y);
		if (dx < 0) {
			if (topLeft || bottomLeft) {
				dx = 0;
				tempX = (col << 4) + getBounds().getWidth() / 2;
			} else {
				tempX += dx;
			}
		}
		if (dx > 0) {
			if (topRight || bottomRight) {
				dx = 0;
				tempX = (col + 1 << 4) - getBounds().getWidth() / 2;
			} else {
				tempX += dx;
			}
		}

		if (!airborne) {
			checkCollision(x, y + 1);
			if (!bottomLeft && !bottomRight) {
				airborne = true;
			}
		}

		x = (int) tempX;
		y = (int) tempY;
	}

	private void checkCollision(double x, double y) {
		int leftTile = (int) getBounds(x, y).getMinX() >> 4;
		int rightTile = (int) (getBounds(x, y).getMaxX() - 1) >> 4;
		int topTile = (int) getBounds(x, y).getMinY() >> 4;
		int bottomTile = (int) (getBounds(x, y).getMaxY() - 1) >> 4;

		topLeft = level.getTile(leftTile, topTile).isSolid();
		topRight = level.getTile(rightTile, topTile).isSolid();
		bottomLeft = level.getTile(leftTile, bottomTile).isSolid();
		bottomRight = level.getTile(rightTile, bottomTile).isSolid();
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
}