package plattformer.graphics;

public class Assets {

    public static Sprite VOID = new Sprite(0, 16);

    // Overworld Level
    public static Sprite OVERWORLD_LEVEL_BG = new Sprite("/basic-background.png");

    public static Sprite GRASS = new Sprite(SpriteSheet.BASIC, 0, 1, 16);
    public static Sprite DIRT = new Sprite(SpriteSheet.BASIC, 1, 1, 16);
    public static Sprite GRASS_LEFT = new Sprite(SpriteSheet.BASIC, 1, 0, 16);
    public static Sprite GRASS_RIGHT = new Sprite(SpriteSheet.BASIC, 2, 0, 16);

    // Player
    public static Sprite PLAYER_IDLE = new Sprite(SpriteSheet.PLAYER, 0, 0, 16);
    public static Sprite PLAYER_WALK_1 = new Sprite(SpriteSheet.PLAYER, 1, 0, 16);
    public static Sprite PLAYER_WALK_2 = new Sprite(SpriteSheet.PLAYER, 2, 0, 16);
    public static Sprite PLAYER_FALL = new Sprite(SpriteSheet.PLAYER, 3, 0, 16);

    private Assets() {
    }
}