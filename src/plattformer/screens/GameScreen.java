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
		
		level.tick();
	}
}