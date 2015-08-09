package plattformer.level;

import plattformer.Game;
import plattformer.level.entities.Entity;
import plattformer.level.tiles.Tile;
import plattformer.level.tiles.Tileset;
import plattformer.screens.Screen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Level {

    public Game game;
    protected int width, height;
    protected Tileset tileset;

    protected int[] tiles;

    public List<Entity> entities = new ArrayList<Entity>();

    public Level(Game game, Tileset tileset) {
        this.game = game;
        this.tileset = tileset;
    }

    protected void loadLevel(String path) {
        System.out.print("Trying to load Level from " + path + "... ");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(path)));
            width = Integer.parseInt(reader.readLine());
            height = Integer.parseInt(reader.readLine());
            tiles = new int[width * height];

            String delimiter = "\\s+"; // Spaces
            for (int y = 0; y < height; y++) {
                String[] rowValues = reader.readLine().split(delimiter);
                for (int x = 0; x < width; x++) {
                    tiles[x + y * width] = Integer.parseInt(rowValues[x]);
                }
            }
            System.out.println("done.");
        } catch (IOException e) {
            System.out.println("failed.");
            e.printStackTrace();
        }
    }

    public void render(Screen screen, int xScroll, int yScroll) {
        screen.renderSprite(tileset.getBackground(), 0, 0, 0, false); // Render background first

        // Then the tiles
        screen.setOffset(xScroll, yScroll);
        int x0 = xScroll >> 4;
        int x1 = (xScroll + game.getScaledWidth() + 16) >> 4;
        int y0 = yScroll >> 4;
        int y1 = (yScroll + game.getScaledHeight() + 16) >> 4;
        for (int y = y0; y < y1; y++) {
            for (int x = x0; x < x1; x++) {
                Tile tile = getTile(x, y);
                tile.render(screen, x, y);
                if (game.showHitboxes && tile.isSolid())
                    screen.drawQuad(0xff0000, x << 4, y << 4, tileset.getTileSize(), tileset.getTileSize());
            }
        }

        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).render(screen);
        }
    }

    public void tick() {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).tick();
        }
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) return Tile.VOID;
        return tileset.getTile(tiles[x + y * width]);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Tileset getTileset() {
        return tileset;
    }
}