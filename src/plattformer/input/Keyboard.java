package plattformer.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import plattformer.Game;

public class Keyboard implements KeyListener {

	private Game game;

	public Keyboard(Game game) {
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		game.onKeyType(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}