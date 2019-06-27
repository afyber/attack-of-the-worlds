package com.attackoftheworlds.enemies;

import com.attackoftheworlds.AttackOfTheWorlds;
import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class PoisonPlanet extends Planet {

    public PoisonPlanet(Texture texture, int x, int y, Random random) {
        super(texture, x, y);
        setupAngle(random);
        this.scale = 1.5f;
    }

    @Override
    public int shipDamage() {
        return 1;
    }

    @Override
    public String specialModifier() {
        return "poison";
    }

    @Override
    public void setupAngle(Random random) {
        double angle = Math.atan2(AttackOfTheWorlds.HEIGHT / 2f - this.loc.y, AttackOfTheWorlds.WIDTH / 2f - this.loc.x);
        this.setAngle((float)Math.toDegrees(angle));
    }
}
