package com.attackoftheworlds.gfx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Sprite {
    private Texture texture;

    protected Vector2 loc;
    protected float angle;
    protected float scale;

    protected float speed;

    // used for rotating
    protected Vector2 origin;

    public Sprite(Texture texture) {
        this(texture, 0, 0);
    }
    public Sprite(Texture texture, float x, float y) {
        this(texture, x, y, 1);
    }
    public Sprite(Texture texture, float x, float y, float scale) {
        this(texture, x, y, 0, 0, scale);
    }
    public Sprite(Texture texture, float x, float y, float originX, float originY) {
        this(texture, x, y, originX, originY, 1);
    }
    public Sprite(Texture texture, float x, float y, float originX, float originY, float scale) {
        this(texture, x, y, originX, originY, scale, 0);
    }
    public Sprite(Texture texture, float x, float y, float originX, float originY, float scale, float angle) {
        this.texture = texture;
        this.loc = new Vector2(x, y);
        this.origin = new Vector2(originX, originY);
        this.scale = scale;
        this.angle = angle;
        speed = 10;
    }

    public void render(SpriteBatch batch) {
        render(batch, this.origin, this.angle);
    }

    public void render(SpriteBatch batch, Vector2 origin, float angle) {
        batch.draw(this.texture, this.loc.x, this.loc.y, origin.x, origin.y, this.texture.getWidth(),
                this.texture.getHeight(), this.scale, this.scale, angle, 0, 0, this.texture.getWidth(),
                this.texture.getHeight(), false, false);
    }

    public void move(float delta) {
        double radians = Math.toRadians(this.angle);
        this.loc.x += this.speed * Math.cos(radians) * delta;
        this.loc.y += this.speed * Math.sin(radians) * delta;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getAngle() {
        return angle;
    }
}
