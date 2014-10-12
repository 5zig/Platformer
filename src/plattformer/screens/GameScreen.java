package plattformer.screens;

import plattformer.Game;
import plattformer.level.Level;

public class GameScreen extends Screen {

	private Level level;

	private int xScroll, yScroll;

	public GameScreen(Game game, Level level) {
		super(game);
		this.level = level;
	}

	public void render() {
		level.render(this, xScroll, yScroll);
	}

	public void tick() {
		if (game.getKeyboard().up) yScroll--;
		if (game.getKeyboard().down) yScroll++;
		if (game.getKeyboard().left) xScroll--;
		if (game.getKeyboard().right) xScroll++;

		// allow screen scroll only till max
		int maxwidth = 80;
		if (xScroll > maxwidth || game.getPlayer().getX() > maxwidth + game.getScaledWidth() / 2 - 40) xScroll = maxwidth;
		if (xScroll < 0 || game.getPlayer().getX() < 0 + game.getScaledWidth() / 2 - 40) xScroll = 0;

		int maxheight = 20;
		if (yScroll > maxheight || game.getPlayer().getY() > maxheight + game.getScaledHeight() / 2) yScroll = maxheight;
		if (yScroll < -maxheight || game.getPlayer().getY() < -maxheight + game.getScaledHeight() / 2) yScroll = -maxheight;

		level.tick();
	}
}