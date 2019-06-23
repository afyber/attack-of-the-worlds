package com.attackoftheworlds.gfx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class AnimatedSprite extends Sprite {

    private Texture[] frames;
    private int currentFrame = 0;

    private int updatesBetweenFrames;
    private int currentUpdate;

    public AnimatedSprite(Texture[] frames, int updatesBetweenFrames) {
        this(frames, updatesBetweenFrames, 0, 0);
    }
    public AnimatedSprite(Texture[] frames, int updatesBetweenFrames, float x, float y) {
        this(frames, updatesBetweenFrames, x, y, 1);
    }
    public AnimatedSprite(Texture[] frames, int updatesBetweenFrames, float x, float y, float scale) {
        this(frames, updatesBetweenFrames, x, y, 0, 0, scale);
    }
    public AnimatedSprite(Texture[] frames, int updatesBetweenFrames, float x, float y, float originX, float originY, float scale) {
        this(frames, updatesBetweenFrames, x, y, originX, originY, scale, 0);
    }
    public AnimatedSprite(Texture[] frames, int updatesBetweenFrames, float x, float y, float originX, float originY, float scale, float angle) {
        super(frames[0], x, y, originX, originY, scale, angle);
        this.frames = frames;
        this.updatesBetweenFrames = updatesBetweenFrames;
    }

    public void update(float delta) {
        if (currentUpdate >= updatesBetweenFrames) {
            incFrame();
            currentUpdate = 0;
        } else {
            currentUpdate++;
        }
    }

    private void incFrame() {
        if (currentFrame >= frames.length - 1) {
            currentFrame = 0;
        } else {
            currentFrame++;
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        render(batch, this.origin, this.angle);
    }

    @Override
    public void render(SpriteBatch batch, Vector2 origin, float angle) {
        Texture texture = frames[currentFrame];

        batch.draw(texture, this.loc.x, this.loc.y, origin.x, origin.y, texture.getWidth(), texture.getHeight(),
                this.scale, this.scale, angle, 0, 0, texture.getWidth(), texture.getHeight(),
                false, false);
    }
}
