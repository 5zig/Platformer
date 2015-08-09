package plattformer.level.tiles;

import plattformer.graphics.Assets;
import plattformer.graphics.Sprite;

public class Tileset {

    private Sprite background;
    private Tile[] tiles;
    private int tileSize;

    public static Tileset OVERWORLD_LEVEL = new Tileset(Assets.OVERWORLD_LEVEL_BG, 16, Tile.VOID, Tile.GRASS, Tile.DIRT, Tile.GRASS_LEFT, Tile.GRASS_RIGHT,
            Tile.DIRT_LEFT, Tile.DIRT_RIGHT, Tile.DIRT_ABOVE, Tile.DIRT_ABOVE_LEFT, Tile.DIRT_ABOVE_RIGHT, Tile.DIRTGRASS_LEFT, Tile.DIRTGRASS_RIGHT,
            Tile.DIRTGRASS_BOTH, Tile.DIRTGRASS_GAP, Tile.FLOWER_1, Tile.FLOWER_2, Tile.FLOWER_3, Tile.ISLAND_LEFT, Tile.ISLAND_MID, Tile.ISLAND_RIGHT);

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
        if (id < 0 || id >= tiles.length)
            return Tile.VOID;
        return tiles[id];
    }

    public int getTileSize() {
        return tileSize;
    }
}