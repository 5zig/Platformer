package plattformer.graphics;

public class Animation {

    private Sprite[] sprites;
    private int currentFrame;

    private long startTime;
    private int delay;

    public void setFrames(Sprite... sprites) {
        this.sprites = sprites;
        if (currentFrame >= sprites.length)
            currentFrame = 0;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void tick() {
        if (delay == -1)
            return;

        long elapsed = (System.nanoTime() - startTime) / 1000000;
        if (elapsed > delay) {
            currentFrame++;
            startTime = System.nanoTime();
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