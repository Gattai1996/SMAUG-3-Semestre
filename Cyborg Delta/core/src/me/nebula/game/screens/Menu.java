package me.nebula.game.screens;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import me.nebula.game.CyborgDelta;
import me.nebula.game.tools.MusicPlayer;



public class Menu extends Game implements Screen {
	
	private static final int EXIT_BUTTON_WIDTH = 154;
	private static final int EXIT_BUTTON_HEIGHT = 54;
	private static final int CONFIG_BUTTON_WIDTH = 154;
	private static final int CONFIG_BUTTON_HEIGHT = 54;
	private static final int PLAY_BUTTON_WIDTH = 154;
	private static final int PLAY_BUTTON_HEIGHT = 54;
	public static int start = 0;
	public static boolean music_conf = true;
	public String music_file;
	
	private CyborgDelta game;
	
	final Menu mainMenuPrincipal = this;
	
	Texture playButton;
	Texture playButtonAnimated;
	Texture exitButtonActive;
	Texture exitButtonInactive;
	Texture configButtonActive;
	Texture configButtonInactive;
	TextureRegion backGround;
	private MusicPlayer threa_m1;
	
	public Menu (CyborgDelta game) {
		this.game = game;
		playButton = new Texture("./Buttons/play.png");
		playButtonAnimated = new Texture("./Buttons/play.png");
		exitButtonActive = new Texture("./Buttons/quit.png");
		configButtonActive = new Texture("./Buttons/config.png");
		backGround = new TextureRegion(new Texture("./Mapas/Menu.png"), 0, 0, 800, 600);
		
		threa_m1 = new MusicPlayer();
		
		threa_m1.start();
		System.out.println("Thread inicada");
		
		//if ( start == 1 | music_conf == false) {
		//	threa_m1.interrupt();
		//}
		
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void render(float delta) {
		
		if (Gdx.input.getX() < 550 + EXIT_BUTTON_WIDTH  && Gdx.input.getX() > 550 && Gdx.input.getY() < 475 + EXIT_BUTTON_HEIGHT && Gdx.input.getY() > 475) {
			if (Gdx.input.isTouched()) {
				System.out.println("Tocando EXIT!");
				mainMenuPrincipal.dispose();
				Gdx.app.exit();
			}
		}
		if (Gdx.input.getX() < 350 + CONFIG_BUTTON_WIDTH && Gdx.input.getX() > 350 && Gdx.input.getY() < 475 + CONFIG_BUTTON_HEIGHT && Gdx.input.getY() > 475) {
			if (Gdx.input.isTouched()) {
				System.out.println("Tocando Config!");
				if (music_conf = false) {
					music_conf = true;
				}else {
					music_conf = false;
				}
				//mainMenuPrincipal.dispose();
				//Gdx.app.exit();
			}
		}
		if (Gdx.input.getX() < 150 + PLAY_BUTTON_WIDTH && Gdx.input.getX() > 150 && Gdx.input.getY() < 475 + PLAY_BUTTON_HEIGHT && Gdx.input.getY() > 475) {
			if (Gdx.input.isTouched()) {
				System.out.println("Tocando PLAY!");
				this.dispose();
				music_conf = false;
				this.game.setScreen(new GameScreen());
				start = 1;
				//game.setScreen(new FasePrincipal(game));
			}
		}
		if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			if (music_conf == true) {
				music_conf = false;
				//threa_m1.pause();
				System.out.println("Esc OK!"+ music_conf);
				// threa_m1.pause();
			} else {
				music_conf = true;
				System.out.println(music_conf);
				//threa_m1.play();
			}
		}
		
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		game.batch.draw(backGround, 0, 0);
		game.batch.draw(playButton, 150, 50, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
		game.batch.draw(configButtonActive, 350, 50, CONFIG_BUTTON_WIDTH, CONFIG_BUTTON_HEIGHT);
		game.batch.draw(exitButtonActive, 550, 50, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
		//game.batch.draw(region, x, y, originX, originY, width, height, scaleX, scaleY, rotation);
		game.batch.end();
		


	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}
	

}