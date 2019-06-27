package com.attackoftheworlds.enemies;

import com.attackoftheworlds.gfx.Sprite;
import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public abstract class Planet extends Sprite {

    Planet(Texture texture, int x, int y) { super(texture, x, y); }

    public abstract int shipDamage();

    public abstract String specialModifier();

    public abstract void setupAngle(Random random);
}
