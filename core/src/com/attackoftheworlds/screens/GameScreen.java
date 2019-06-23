package com.attackoftheworlds.screens;

import com.attackoftheworlds.AttackOfTheWorlds;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

/** keeps track of all the things in the main game
 * @author afyber*/
public class GameScreen implements Screen {

    private AttackOfTheWorlds game;
    private boolean hasFocus;
    private boolean paused = false;

    private OrthographicCamera camera;

    // start at 20 health
    private int peopleLeft = 20;

    /** initializes the game end screen
    * @param game the instance of {@link AttackOfTheWorlds} to use */
    public GameScreen(AttackOfTheWorlds game) {
        this.game = game;
        hasFocus = true;

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

        // game logic
        if (hasFocus && !paused) {
            // you lost
            if (peopleLeft <= 0)
                this.game.setScreen(new EndGameScreen(this.game, peopleLeft));
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
