package plattformer.level.entities;

import plattformer.graphics.Sprite;
import plattformer.level.Level;
import plattformer.screens.Screen;

public class Player extends Entity {

	public Player(Level level, int x, int y) {
		super(level, x, y);
	}

	@Override
	public void render(Screen screen) {
		screen.renderSprite(Sprite.PLAYER_1, x, y, true);
	}

}
