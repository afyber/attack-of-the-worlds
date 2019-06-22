package com.attackoftheworlds;

import com.attackoftheworlds.screens.MainMenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/** The game class, mostly used for drawing with the SpriteBatch */
public class AttackOfTheWorlds extends Game {
	// use this for all drawing in all the screens
	public SpriteBatch batch;

	// for the window
	public static final int WIDTH = 854;
	public static final int HEIGHT = 480;

	/** prepares and starts the game */
	@Override
	public void create() {
		batch = new SpriteBatch();

		this.setScreen(new MainMenuScreen(this));
	}

	/** this is important */
	@Override
	public void render() {
		super.render();
	}

	/** dispose of everything that needs to be */
	@Override
	public void dispose() {
		batch.dispose();
	}
}
