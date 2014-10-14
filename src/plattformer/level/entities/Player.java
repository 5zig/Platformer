package plattformer.level.entities;

import plattformer.graphics.Sprite;
import plattformer.level.Level;
import plattformer.screens.Screen;
import plattformer.util.Vector2f;

public class Player extends Mob {

	public Player(Level level, int x, int y) {
		super(level, x, y);
	}

	public void render(Screen screen) {
		screen.renderSprite(Sprite.PLAYER_1, x, y, direction, true);
	}

	public void tick() {
		super.tick();

		int xa = 0, ya = 0;
		if (level.game.getKeyboard().left) xa--;
		if (level.game.getKeyboard().right) xa++;

		if (level.game.getKeyboard().space || level.game.getKeyboard().up) {
			if (!hasVelocity() && onGround()) setVelocity(new Vector2f(0.0f, 3.0f));
		}

		if (xa != 0 || ya != 0) move(xa, ya);
	}
}