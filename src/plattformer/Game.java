package plattformer;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import plattformer.input.Keyboard;
import plattformer.screens.DebugScreen;
import plattformer.screens.Screen;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -114521740095634942L;

	private JFrame frame;
	private final String TITLE = "Platformer";
	private final int WIDTH = 300;
	private final int HEIGHT = WIDTH * 9 / 16;
	private final int SCALE = 3;

	private Thread mainThread;
	private boolean running;

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	private Keyboard keyboard;
	private Screen currentScreen;

	public Game() {
		currentScreen = new DebugScreen(this);
		keyboard = new Keyboard(this);
		addKeyListener(keyboard);
	}

	public void create() {
		frame = new JFrame(TITLE);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.add(this);
		frame.setVisible(true);
	}

	public synchronized void start() {
		running = true;
		mainThread = new Thread(this, "Main Thread");
		mainThread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			mainThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		requestFocus();
		while (running) {
			render();
		}
		stop();
	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		currentScreen.clear();
		currentScreen.render();
		
		for (int i = 0; i < currentScreen.pixels.length; i++) {
			pixels[i] = currentScreen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}
	
	private void tick() {
		currentScreen.tick();
	}
	
	public void onKeyType(int keycode) {
		currentScreen.onKey(keycode);
	}

	public int getScaledWidth() {
		return WIDTH;
	}

	public int getScaledHeight() {
		return HEIGHT;
	}

}
