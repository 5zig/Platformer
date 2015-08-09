package plattformer.level.entities;

import plattformer.graphics.Animation;
import plattformer.graphics.Assets;
import plattformer.level.Level;
import plattformer.screens.Screen;

public class Player extends Mob {

    private Animation animation;
    private int anim; // 0 = Idle; 1 = Walking; 2 = Falling

    public Player(Level level, int x, int y) {
        super(level, x, y);
        hWidth = 8;
        hHeight = 15;
        hXOffs = 4;
        hYOffs = 7;

        animation = new Animation();
        animation.setFrames(Assets.PLAYER_IDLE);
        animation.setFPS(-1);
    }

    public void render(Screen screen) {
        screen.renderSprite(animation.getCurrentSprite(), x - animation.getCurrentSprite().getWidth() / 2, y - animation.getCurrentSprite().getHeight() / 2, direction, true);
        if (level.game.showHitboxes)
            screen.drawQuad(0x0000ff, (int) getBounds().getX(), (int) getBounds().getY(), (int) getBounds().getWidth(), (int) getBounds().getHeight());
    }

    public void tick() {
        super.tick();

        if (level.game.getKeyboard().left) left = true;
        else left = false;

        if (level.game.getKeyboard().right) right = true;
        else right = false;

        if (level.game.getKeyboard().up || level.game.getKeyboard().space) {
            jump();
        }

        updateAnimation();
    }

    private void updateAnimation() {
        if (!airborne && !left && !right && anim != 0) {
            animation.setFrames(Assets.PLAYER_IDLE);
            animation.setFPS(-1);
            anim = 0;
        } else if ((left || right) && !airborne && anim != 1) {
            animation.setFrames(Assets.PLAYER_WALK_1, Assets.PLAYER_WALK_2);
            animation.setFPS(15);
            anim = 1;
        } else if (airborne && anim != 2) {
            animation.setFrames(Assets.PLAYER_FALL);
            animation.setFPS(-1);
            anim = 3;
        }
        animation.tick();
    }
}