package plattformer.level.entities;

import plattformer.graphics.Sprite;
import plattformer.level.Level;
import plattformer.math.Vector2f;
import plattformer.screens.Screen;

import java.awt.*;

public class Player extends Mob {

	public Player(Level level, int x, int y) {
		super(level, x, y);
	}

	public void render(Screen screen) {
		screen.renderSprite(Sprite.PLAYER_1, x - 16, y - 32, direction, true);
		screen.drawQuad(0xff0000, (int) getBounds().getX(), (int) getBounds().getY(), (int) getBounds().getWidth(), (int) getBounds().getHeight());
	}

	public void tick() {
		super.tick();

		int xa = 0, ya = 0;
		if (level.game.getKeyboard().left) xa--;
		if (level.game.getKeyboard().right) xa++;

		if (level.game.getKeyboard().space || level.game.getKeyboard().up) {
			if (!hasVelocity() && onGround()) setVelocity(new Vector2f(0.0f, 2.0f));
		}

		if (xa != 0 || ya != 0) move(xa, ya);
	}

	public Rectangle getBounds() {
		return new Rectangle(x - 16, y - 32, 32, 32);
	}
}