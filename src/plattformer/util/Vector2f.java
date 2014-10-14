package plattformer.util;

public class Vector2f {

	private float x, y;

	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Vector2f setX(float x) {
		this.x = x;
		return this;
	}

	public Vector2f setY(float y) {
		this.y = y;
		return this;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public Vector2f subtractX(float x) {
		if (this.x > 0) this.x -= x;
		return this;
	}
	
	public Vector2f subtractY(float y) {
		if (this.y > 0) this.y -= y;
		return this;
	}

	public Vector2f add(Vector2f vec2f) {
		this.x += vec2f.getX();
		this.y += vec2f.getY();
		return this;
	}

	public Vector2f subtract(Vector2f vec2f) {
		this.x -= vec2f.getX();
		this.y -= vec2f.getY();
		return this;
	}

	public float length() {
		return (float) Math.sqrt((x * x) + (y * y));
	}

	@Override
	public String toString() {
		return "Vec2f[x=" + x + ", y=" + y + "]";
	}

}