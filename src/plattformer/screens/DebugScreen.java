package plattformer.screens;

import java.util.Random;

import plattformer.Game;

public class DebugScreen extends Screen {

	private final Random r = new Random();

	public DebugScreen(Game game) {
		super(game);
	}
	
	private int ticks; //Only temporarily
	
	@Override
	public void tick() {
		ticks++;
	}
	
	@Override
	public void render() {
		//pixels[r.nextInt(pixels.length)] = 0xffffff;
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = i + ticks;
		}
	}

	@Override
	public void onKey(int keycode) {
		System.out.println("key: " + keycode);
	}

	@Override
	public void onMouseClick(int x, int y, int button) {
		System.out.println("mouse: " + button + " - " + x + ", " + y);
	}

}
