package plattformer.level;

import java.util.ArrayList;
import java.util.List;

import plattformer.Game;
import plattformer.level.entities.Entity;
import plattformer.level.tiles.Tile;
import plattformer.screens.Screen;

public class Level {

	public Game game;
	protected int width, height;

	protected int[] tiles;

	public List<Entity> entities = new ArrayList<Entity>();

	public Level(Game game) {
		this.game = game;
		loadLevel();
	}

	protected void loadLevel() {
	}

	public void render(Screen screen, int xScroll, int yScroll) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + game.getScaledWidth() + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + game.getScaledHeight() + 16) >> 4;
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(screen, x, y);
			}
		}
		
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
	}

	public void tick() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).tick();
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || x >= width || y < 0 || y >= height) return Tile.VOID;
		if (tiles[x + y * width] == Tile.COL_GRASS) return Tile.GRASS;
		return Tile.VOID;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}