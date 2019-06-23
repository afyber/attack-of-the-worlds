package com.attackoftheworlds.screens;

import com.attackoftheworlds.AttackOfTheWorlds;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

/** screen for selecting play, or options
 *  @author afyber */
public class MainMenuScreen implements Screen {

    private AttackOfTheWorlds game;
    private boolean hasFocus = true;
    private boolean paused = false;

    private OrthographicCamera camera;

    /** initializes the game end screen
    * @param game the instance of {@link AttackOfTheWorlds} to use */
    public MainMenuScreen(AttackOfTheWorlds game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, AttackOfTheWorlds.WIDTH, AttackOfTheWorlds.HEIGHT);
    }

    @Override
    public void render(float delta) {
        // clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // stuff for the camera
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        // check for if we want a new game, to continue, or to quit
        if (hasFocus && !paused) {

        }

        // rendering
        game.batch.begin();
        // all calls to render() go here
        game.batch.end();
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
