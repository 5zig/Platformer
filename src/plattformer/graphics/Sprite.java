package plattformer.graphics;

public class Sprite {

	private int[] pixels;
	private int size;

	public static final Sprite GRASS = new Sprite(SpriteSheet.TEST, 0, 0, 16);
	public static final Sprite TESTSPRITE = new Sprite(SpriteSheet.TEST, 1, 0, 16);
	public static final Sprite VOID = new Sprite(0x00AEFF, 16);

	// Player
	public static final Sprite PLAYER_IDLE = new Sprite(SpriteSheet.PLAYER, 0, 0, 16);
	public static final Sprite PLAYER_WALK_1 = new Sprite(SpriteSheet.PLAYER, 1, 0, 16);
	public static final Sprite PLAYER_WALK_2 = new Sprite(SpriteSheet.PLAYER, 2, 0, 16);
	public static final Sprite PLAYER_FALL = new Sprite(SpriteSheet.PLAYER, 3, 0, 16);

	/**
	 * Extract a sprite from the spritesheet with specific coordinates
	 * 
	 * @param sheet
	 *            Spritesheet
	 * @param x
	 *            X-Coordinate
	 * @param y
	 *            Y-Coordinate
	 * @param size
	 *            The Size of the Sprite
	 */
	public Sprite(SpriteSheet sheet, int x, int y, int size) {
		pixels = new int[size * size];
		this.size = size;

		for (int yy = 0; yy < size; yy++) {
			int yo = y * size + yy;
			for (int xx = 0; xx < size; xx++) {
				int xo = x * size + xx;
				pixels[xx + yy * size] = sheet.getPixels()[xo + yo * sheet.getWidth()];
			}
		}
	}

	public Sprite(int col, int size) {
		this.size = size;
		pixels = new int[size * size];

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = col;
		}
	}

	public int[] getPixels() {
		return pixels;
	}

	public int getSize() {
		return size;
	}
}