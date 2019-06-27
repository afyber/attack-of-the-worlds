package com.attackoftheworlds;

import com.attackoftheworlds.screens.LoadingScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

/** The game class, mostly used for drawing with the SpriteBatch */
public class AttackOfTheWorlds extends Game {
	// use this for all drawing in all the screens
	public SpriteBatch batch;
	// used for getting sprites and others
	public AssetManager assets;

	public BitmapFont font;

	public Random random;

	// for the window
	public static final int WIDTH = 854;
	public static final int HEIGHT = 480;

	/** prepares and starts the game */
	@Override
	public void create() {
		batch = new SpriteBatch();
		assets = new AssetManager();
		// a temporary font
		font = new BitmapFont();

		random = new Random();

		this.setScreen(new LoadingScreen(this));
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
		assets.dispose();
	}
}
