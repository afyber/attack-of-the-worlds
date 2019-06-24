package com.attackoftheworlds.screens;

import com.attackoftheworlds.AttackOfTheWorlds;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

/** shows while the game loads all the sprites
 * @author afyber */
public class LoadingScreen implements Screen {

    private AttackOfTheWorlds game;

    private OrthographicCamera camera;

    /** initializes the game end screen
     * @param game the instance of {@link AttackOfTheWorlds} to use */
    public LoadingScreen(AttackOfTheWorlds game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, AttackOfTheWorlds.WIDTH, AttackOfTheWorlds.HEIGHT);

        game.assets.load("sprites/earth.png", Texture.class);
        game.assets.load("sprites/mars.png", Texture.class);
        game.assets.load("sprites/poisonbis.png", Texture.class);
        game.assets.load("sprites/ship_frame1.png", Texture.class);
        game.assets.load("sprites/ship_frame2.png", Texture.class);
        game.assets.load("sprites/cannon.png", Texture.class);
        game.assets.load("sprites/small_star.png", Texture.class);
    }

    @Override
    public void render(float delta) {
        // clear the screen
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // stuff for the camera
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        // check for if we want a new game, to continue, or to quit
        if (this.game.assets.update()) {
            this.game.setScreen(new MainMenuScreen(this.game));
        }

        // rendering
        game.batch.begin();
        // all calls to render() go here
        game.font.draw(game.batch, "LOADING...", 400, 300);

        game.batch.end();
    }

    @Override
    public void show() {
        // doesn't need to do anything
    }

    @Override
    public void hide() {
        // doesn't need to do anything
    }

    @Override
    public void resume() {
        // doesn't need to do anything
    }

    @Override
    public void pause() {
        // doesn't need to do anything
    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {
        // shouldn't need to do anything here
    }
}
