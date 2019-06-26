package com.attackoftheworlds.enemies;

import com.attackoftheworlds.AttackOfTheWorlds;
import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class EarthPlanet extends Planet {

    public EarthPlanet(Texture texture, int x, int y, Random random) {
        super(texture, x, y);
        setupAngle(random);
        this.scale = 2;
    }

    @Override
    public int shipDamage() {
        return 2;
    }

    @Override
    public String specialModifier() {
        return null;
    }

    @Override
    public void setupAngle(Random random) {
        double angle = Math.atan2(AttackOfTheWorlds.WIDTH / 2f - this.loc.x, AttackOfTheWorlds.HEIGHT / 2f - this.loc.y);
        this.angle = (float)Math.toDegrees(angle) - 45 + random.nextInt(10) - 5;
    }
}
