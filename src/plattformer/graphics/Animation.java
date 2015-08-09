package plattformer.graphics;

public class Animation {

    private Sprite[] sprites;
    private int currentFrame;

    private int timer;
    private int fps;

    public void setFrames(Sprite... sprites) {
        this.sprites = sprites;
        if (currentFrame >= sprites.length)
            currentFrame = 0;
    }

    public void setFPS(int fps) {
        this.fps = fps;
    }

    public void tick() {
        if (fps == -1)
            return;

        timer++;
        if (timer > 60 / fps) {
            currentFrame++;
            timer = 0;
        }

        if (currentFrame >= sprites.length)
            currentFrame = 0;
    }

    public int getFrames() {
        return sprites.length;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public Sprite getCurrentSprite() {
        return sprites[currentFrame];
    }
}