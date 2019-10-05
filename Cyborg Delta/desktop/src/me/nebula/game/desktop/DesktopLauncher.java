package me.nebula.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import me.nebula.game.CyborgDelta;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Cyborg Delta";
		config.foregroundFPS = 60;
		//config.useGL30 = true;
		config.width = 800;
		config.height = 600;
		config.resizable = false;
		new LwjglApplication(new CyborgDelta(), config);
	}
}