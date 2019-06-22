package com.attackoftheworlds.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.attackoftheworlds.AttackOfTheWorlds;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.resizable = false;
		config.foregroundFPS = 60;
		config.backgroundFPS = 60;
		config.title = "Attack of the Worlds";
		config.width = AttackOfTheWorlds.WIDTH;
		config.height = AttackOfTheWorlds.HEIGHT;
		new LwjglApplication(new AttackOfTheWorlds(), config);
	}
}
