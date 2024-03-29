package com.attackoftheworlds.screens;

import com.attackoftheworlds.AttackOfTheWorlds;
import com.attackoftheworlds.enemies.EarthPlanet;
import com.attackoftheworlds.enemies.MarsPlanet;
import com.attackoftheworlds.enemies.Planet;
import com.attackoftheworlds.enemies.PoisonPlanet;
import com.attackoftheworlds.gfx.AnimatedSprite;
import com.attackoftheworlds.gfx.Sprite;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/** keeps track of all the things in the main game
 * @author afyber*/
public class GameScreen implements Screen {
    private static final int NUM_STARS = 20;

    private AttackOfTheWorlds game;
    private boolean hasFocus;
    private boolean paused = false;

    private OrthographicCamera camera;

    // start at 20 health
    private int peopleLeft;

    private AnimatedSprite ship;
    private Sprite cannon;

    private Sprite[] stars;

    private ArrayList<Planet> planets;

    /** initializes the game end screen
    * @param game the instance of {@link AttackOfTheWorlds} to use */
    public GameScreen(AttackOfTheWorlds game) {
        this.game = game;
        hasFocus = true;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, AttackOfTheWorlds.WIDTH, AttackOfTheWorlds.HEIGHT);

        peopleLeft = 20;
        Texture[] frames = new Texture[]{game.assets.get("sprites/ship_frame1.png"), game.assets.get("sprites/ship_frame2.png")};
        ship = new AnimatedSprite(frames, 60, AttackOfTheWorlds.WIDTH / 2f - 40, AttackOfTheWorlds.HEIGHT / 2f - 40, 2);

        cannon = new Sprite(game.assets.get("sprites/cannon.png", Texture.class), AttackOfTheWorlds.WIDTH / 2f - 34, AttackOfTheWorlds.HEIGHT / 2f - 34, 1.5f);

        stars = getRandomStars();

        planets = new ArrayList<Planet>();
        planets.add(new EarthPlanet(game.assets.get("sprites/earth.png", Texture.class), 100, 100, game.random));
        planets.add(new MarsPlanet(game.assets.get("sprites/mars.png", Texture.class), 400, 400, game.random));
        planets.add(new PoisonPlanet(game.assets.get("sprites/poison.png", Texture.class), 700, 200, game.random));
    }

    @Override
    public void render(float delta) {
        // clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // stuff for the camera
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        // game logic
        if (hasFocus && !paused) {
            // you lost
            if (peopleLeft <= 0)
                this.game.setScreen(new EndGameScreen(this.game, peopleLeft));

            ship.update(delta);

            Vector2 mouseLoc = new Vector2(Gdx.input.getX(), Gdx.input.getY());
            // not the way you're supposed to do it, it should be y then x, but this prevents weird stuff
            double cannonAngle = Math.atan2(AttackOfTheWorlds.WIDTH / 2f - mouseLoc.x, AttackOfTheWorlds.HEIGHT / 2f - mouseLoc.y);

            cannon.setAngle((float)Math.toDegrees(cannonAngle) - 90);

            for (Planet planet : planets) {
                planet.move(delta);
            }
        }

        // rendering
        game.batch.begin();
        // all calls to render() go here
        for (Sprite star : stars) {
            star.render(game.batch);
        }

        ship.render(game.batch);
        cannon.render(game.batch);

        for (Planet planet : planets) {
            planet.render(game.batch);
        }

        game.batch.end();
    }

    private Sprite[] getRandomStars() {
        Sprite[] stars = new Sprite[NUM_STARS];

        for (int i = 0; i < NUM_STARS; i++) {
            stars[i] = new Sprite(game.assets.get("sprites/small_star.png", Texture.class), game.random.nextInt(AttackOfTheWorlds.WIDTH),
                    game.random.nextInt(AttackOfTheWorlds.HEIGHT), game.random.nextFloat() + 0.5f);
        }

        return stars;
    }

    @Override
    public void show() {
        hasFocus = true;
    }

    @Override
    public void hide() {
        hasFocus = false;
    }

    @Override
    public void resume() {
        paused = false;
    }

    @Override
    public void pause() {
        paused = true;
    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {
        // shouldn't need to do anything here
    }
}
