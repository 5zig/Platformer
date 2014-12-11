package plattformer.input;

import plattformer.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	private Game game;

	public boolean[] keys = new boolean[Short.MAX_VALUE];
	public boolean up, down, left, right, space, hitbox;

	public Keyboard(Game game) {
		this.game = game;
	}
	
	public void tick() {
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		space = keys[KeyEvent.VK_SPACE];
		hitbox = keys[KeyEvent.VK_H] && keys[KeyEvent.VK_SHIFT];
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		game.getCurrentScreen().onKey(e.getKeyCode());
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
	}
}