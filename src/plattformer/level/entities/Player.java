package plattformer.level.entities;

import plattformer.graphics.Animation;
import plattformer.graphics.Sprite;
import plattformer.level.Level;
import plattformer.screens.Screen;

import java.awt.*;

public class Player extends Mob {

    private Animation animation;
    private int anim; // 0 = Idle; 1 = Walking; 2 = Falling

    public Player(Level level, int x, int y) {
        super(level, x, y);
        animation = new Animation();
        animation.setFrames(Sprite.PLAYER_IDLE);
        animation.setDelay(-1);
    }

    public void render(Screen screen) {
        screen.renderSprite(animation.getCurrentSprite(), x - animation.getCurrentSprite().getSize() / 2, y - animation.getCurrentSprite().getSize() / 2, direction, true);
        if (level.game.showHitboxes)
            screen.drawQuad(0xff0000, (int) getBounds().getX(), (int) getBounds().getY(), (int) getBounds().getWidth(), (int) getBounds().getHeight());
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
            animation.setFrames(Sprite.PLAYER_IDLE);
            animation.setDelay(-1);
            anim = 0;
        } else if ((left || right) && !airborne && anim != 1) {
            animation.setFrames(Sprite.PLAYER_WALK_1, Sprite.PLAYER_WALK_2);
            animation.setDelay(100);
            anim = 1;
        } else if (airborne && anim != 2) {
            animation.setFrames(Sprite.PLAYER_FALL);
            animation.setDelay(-1);
            anim = 3;
        }
        animation.tick();
    }

    public Rectangle getBounds() {
        return new Rectangle(x - 8, y - 8, 16, 16);
    }
}