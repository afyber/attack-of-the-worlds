package com.attackoftheworlds.screens;

import com.attackoftheworlds.AttackOfTheWorlds;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

/** used for the screen at the end of the game
 * @author afyber */
public class EndGameScreen implements Screen {

    private AttackOfTheWorlds game;
    private boolean hasFocus = true;
    private boolean paused = false;

    private OrthographicCamera camera;

    private EndingType ending;

    /** initializes the game end screen
     * @param game the instance of {@link AttackOfTheWorlds} to use
     * @param peopleLeft determines the ending, the more people, the better the ending */
    public EndGameScreen(AttackOfTheWorlds game, int peopleLeft) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, AttackOfTheWorlds.WIDTH, AttackOfTheWorlds.HEIGHT);

        if (peopleLeft <= 0) {
            ending = EndingType.GAME_OVER;
        } else if (peopleLeft <= 10) {
            ending = EndingType.NORMAL;
        } else if (peopleLeft < 20) {
            ending = EndingType.MORE_THAN_10;
        } else if (peopleLeft == 20) {
            ending = EndingType.BEST;
        }
    }

    @Override
    public void render(float delta) {
        // clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // stuff for the camera
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        // just play the animation that goes with this ending
        if (hasFocus && !paused) {
            // only play the animation if the window has focus (if another window isn't selected)
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
