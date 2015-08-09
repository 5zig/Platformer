package plattformer.level.tiles;

import plattformer.graphics.Assets;
import plattformer.graphics.Sprite;

public class Tileset {

    private Sprite background;
    private Tile[] tiles;
    private int tileSize;

    public static Tileset OVERWORLD_LEVEL = new Tileset(Assets.OVERWORLD_LEVEL_BG, 16, Tile.GRASS, Tile.DIRT, Tile.GRASS_LEFT, Tile.GRASS_RIGHT);

    public Tileset(Sprite background, int tileSize, Tile... tiles) {
        this.background = background;
        this.tileSize = tileSize;
        this.tiles = tiles;
    }

    public Sprite getBackground() {
        return background;
    }

    public Tile[] getTiles() {
        return tiles;
    }

    public Tile getTile(int id) {
        int newid = id - 1; // Tile 0 should always be void
        if (newid < 0 || newid >= tiles.length)
            return Tile.VOID;
        return tiles[newid];
    }

    public int getTileSize() {
        return tileSize;
    }
}