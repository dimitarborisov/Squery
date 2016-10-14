package com.squary.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.squary.game.GameSquary;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.resizable = false;
		config.title = GameSquary.TITLE;
		config.height = GameSquary.VHEIGHT;
		config.width = GameSquary.VWIDTH;
		//config.fullscreen = true;
		config.vSyncEnabled = true;
		
		new LwjglApplication(new GameSquary(), config);
	}
}
