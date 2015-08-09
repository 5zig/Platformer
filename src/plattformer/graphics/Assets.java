package plattformer.graphics;

public class Assets {

    public static Sprite VOID = new Sprite(0, 16);

    // Overworld Level
    public static Sprite OVERWORLD_LEVEL_BG = new Sprite("/basic-background.png");

    public static Sprite GRASS = new Sprite(SpriteSheet.BASIC, 0, 1, 16);
    public static Sprite DIRT = new Sprite(SpriteSheet.BASIC, 1, 1, 16);
    public static Sprite GRASS_LEFT = new Sprite(SpriteSheet.BASIC, 2, 0, 16);
    public static Sprite GRASS_RIGHT = new Sprite(SpriteSheet.BASIC, 1, 0, 16);
    public static Sprite DIRT_LEFT = new Sprite(SpriteSheet.BASIC, 4, 0, 16);
    public static Sprite DIRT_RIGHT = new Sprite(SpriteSheet.BASIC, 3, 0, 16);
    public static Sprite DIRT_ABOVE = new Sprite(SpriteSheet.BASIC, 17, 0, 16);
    public static Sprite DIRT_ABOVE_LEFT = new Sprite(SpriteSheet.BASIC, 19, 0, 16);
    public static Sprite DIRT_ABOVE_RIGHT = new Sprite(SpriteSheet.BASIC, 18, 0, 16);
    public static Sprite DIRTGRASS_LEFT = new Sprite(SpriteSheet.BASIC, 5, 0, 16);
    public static Sprite DIRTGRASS_RIGHT = new Sprite(SpriteSheet.BASIC, 6, 0, 16);
    public static Sprite DIRTGRASS_BOTH = new Sprite(SpriteSheet.BASIC, 7, 0, 16);
    public static Sprite DIRTGRASS_GAP = new Sprite(SpriteSheet.BASIC, 8, 0, 16);
    public static Sprite FLOWER_1 = new Sprite(SpriteSheet.BASIC, 9, 0, 16);
    public static Sprite FLOWER_2 = new Sprite(SpriteSheet.BASIC, 10, 0, 16);
    public static Sprite FLOWER_3 = new Sprite(SpriteSheet.BASIC, 11, 0, 16);
    public static Sprite ISLAND_LEFT = new Sprite(SpriteSheet.BASIC, 2, 1, 16);
    public static Sprite ISLAND_MID = new Sprite(SpriteSheet.BASIC, 3, 1, 16);
    public static Sprite ISLAND_RIGHT = new Sprite(SpriteSheet.BASIC, 4, 1, 16);

    // Player
    public static Sprite PLAYER_IDLE = new Sprite(SpriteSheet.PLAYER, 0, 0, 16);
    public static Sprite PLAYER_WALK_1 = new Sprite(SpriteSheet.PLAYER, 1, 0, 16);
    public static Sprite PLAYER_WALK_2 = new Sprite(SpriteSheet.PLAYER, 2, 0, 16);
    public static Sprite PLAYER_FALL = new Sprite(SpriteSheet.PLAYER, 3, 0, 16);

    private Assets() {
    }
}