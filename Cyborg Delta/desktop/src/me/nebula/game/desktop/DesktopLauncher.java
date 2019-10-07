package me.nebula.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import me.nebula.game.helpers.GameInfo;
import me.nebula.game.main.GameMain;

public class DesktopLauncher {

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Cyborg Delta";
		config.foregroundFPS = 60;
		// Tamanho da tela
		config.width = GameInfo.WIDTH;
		config.height = GameInfo.HEIGHT;
		config.resizable = false;
		config.fullscreen = true;
		new LwjglApplication(new GameMain(), config);
	}

}