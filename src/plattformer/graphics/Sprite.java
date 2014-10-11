package plattformer.graphics;

public class Sprite {

	private int[] pixels;
	private int size;

	
	public static final Sprite TEST = new Sprite(Spritesheet.TEST, 0, 0, 16);
	
	/**
	 * Extract a sprite from the spritesheet with specific coordinates
	 * 
	 * @param sheet
	 *            Spritesheet
	 * @param x
	 *            X-Coordinate
	 * @param y
	 *            Y-Coordinate
	 */
	public Sprite(Spritesheet sheet, int x, int y, int size) {
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
	
	public int[] getPixels() {
		return pixels;
	}
	
	public int getSize() {
		return size;
	}

}
