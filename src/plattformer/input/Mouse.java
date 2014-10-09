package plattformer.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import plattformer.Game;

public class Mouse implements MouseListener {

	private Game game;

	public Mouse(Game game) {
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		game.onMouseClick(e.getX() / game.getScale(), e.getY() / game.getScale(), e.getButton());
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}
