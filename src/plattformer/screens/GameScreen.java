package plattformer.screens;

import plattformer.Game;
import plattformer.level.Level;

public class GameScreen extends Screen {

	private Level level;

	public GameScreen(Game game, Level level) {
		super(game);
		this.level = level;
	}

	public void render() {
		level.render(this, 0, 0);
	}

	public void tick() {
		level.tick();
	}
}