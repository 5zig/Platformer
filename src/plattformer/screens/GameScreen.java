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
		level.tick();

		xScroll = game.getPlayer().getX() - game.getScaledWidth() / 2;
		yScroll = game.getPlayer().getY() - game.getScaledHeight() / 2;
		
		// allow screen scroll only til max
		int maxwidth = level.getWidth();
		if (xScroll > maxwidth) xScroll = maxwidth;
		if (xScroll < 0) xScroll = 0;

		int maxheight = level.getHeight();
		if (yScroll > maxheight) yScroll = maxheight;
		if (yScroll < 0) yScroll = 0;

	}
}