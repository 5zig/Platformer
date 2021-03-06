package plattformer;

import plattformer.input.Keyboard;
import plattformer.input.Mouse;
import plattformer.level.Level;
import plattformer.level.SpawnLevel;
import plattformer.level.entities.Player;
import plattformer.screens.GameScreen;
import plattformer.screens.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -114521740095634942L;

	public static final String TITLE = "Platformer";
	public static final int WIDTH = 300;
	public static final int HEIGHT = WIDTH * 9 / 16;
	public static final int SCALE = 4;

	private JFrame frame;
	private Thread mainThread;
	private boolean running;

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	private Mouse mouse;
	private Keyboard keyboard;
	private Screen currentScreen;

	private Player player;

	public boolean showHitboxes = false;

	public Game() {
		Level level = new SpawnLevel(this);
		currentScreen = new GameScreen(this, level);
		mouse = new Mouse(this);
		addMouseListener(mouse);
		keyboard = new Keyboard(this);
		addKeyListener(keyboard);
		player = new Player(level, 30, 100);
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
		long lastTime = System.nanoTime();
		double ns = 1000000000.0 / 60.0;
		double delta = 0;
		long lastTimer = System.currentTimeMillis();
		int ticks = 0, frames = 0;
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while (delta >= 1) {
				tick();
				ticks++;
				delta--;
			}

			render();
			frames++;

			if (System.currentTimeMillis() - lastTimer > 1000) {
				lastTimer += 1000;
				System.out.println(ticks + " ticks, " + frames + " fps");
				frame.setTitle(TITLE + " - " + ticks + " tps, " + frames + " fps");
				ticks = 0;
				frames = 0;
			}
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
		keyboard.tick();

		if (keyboard.hitbox) {
			if (!hitboxKeyPressed) {
				showHitboxes = !showHitboxes;
			}
			hitboxKeyPressed = true;
		} else {
			hitboxKeyPressed = false;
		}
	}

	private boolean hitboxKeyPressed = false;

	public void displayScreen(Screen screen) {
		this.currentScreen = screen;
	}

	public Screen getCurrentScreen() {
		return currentScreen;
	}

	public int getScaledWidth() {
		return WIDTH;
	}

	public int getScaledHeight() {
		return HEIGHT;
	}

	public int getScale() {
		return SCALE;
	}

	public Keyboard getKeyboard() {
		return keyboard;
	}
	
	public Player getPlayer() {
		return player;
	}
}