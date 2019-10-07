package me.nebula.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import me.nebula.game.helpers.GameInfo;
import me.nebula.game.main.GameMain;
import me.nebula.game.huds.MainMenuButtons;

public class MainMenu implements Screen {

	private GameMain game;
	private OrthographicCamera mainCamera;
	private Viewport gameViewport;
	private Texture bg;
	private MainMenuButtons buttons;

//	private static final int EXIT_BUTTON_WIDTH = 154;
//	private static final int EXIT_BUTTON_HEIGHT = 54;
//	private static final int CONFIG_BUTTON_WIDTH = 154;
//	private static final int CONFIG_BUTTON_HEIGHT = 54;
//	private static final int PLAY_BUTTON_WIDTH = 154;
//	private static final int PLAY_BUTTON_HEIGHT = 54;
//	public static int start = 0;
//	public static boolean music_conf = true;
//	public String music_file;
//	private MainMenu mainMainMenuPrincipal = this;
//	private Texture playButton;
//	private Texture playButtonAnimated;
//	private Texture exitButtonActive;
//	Texture exitButtonInactive;
//	private Texture configButtonActive;
//	Texture configButtonInactive;
//	private TextureRegion backGround;
//	private MusicPlayer threa_m1;

	public MainMenu(GameMain game) {

		this.game = game;
//		playButton = new Texture("./Buttons/play.png");
//		playButtonAnimated = new Texture("./Buttons/play.png");
//		exitButtonActive = new Texture("./Buttons/quit.png");
//		configButtonActive = new Texture("./Buttons/config.png");
//		backGround = new TextureRegion(new Texture("./Mapas/Menu.png"), 0, 0, 800, 600);
//		threa_m1 = new MusicPlayer();
		// threa_m1.start();
		// System.out.println("Thread inicada");
		mainCamera = new OrthographicCamera();
		mainCamera.setToOrtho(false, GameInfo.WIDTH, GameInfo.HEIGHT);
		mainCamera.position.set(GameInfo.WIDTH / 2f, GameInfo.HEIGHT / 2f, 0);
		gameViewport = new StretchViewport(GameInfo.WIDTH, GameInfo.HEIGHT, mainCamera);
		bg = new Texture("Mapas/Menu.png");
		buttons = new MainMenuButtons(game);

	} // Fim construtor
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		// Método equivalente ao create
		
	} // Fim show

	@Override
	public void render(float delta) {
		// Método equivalente ao render da classe GameMain
//
//		if (Gdx.input.getX() < 550 + EXIT_BUTTON_WIDTH  && Gdx.input.getX() > 550 && Gdx.input.getY() < 475 + EXIT_BUTTON_HEIGHT && Gdx.input.getY() > 475) {
//			if (Gdx.input.isTouched()) {
//				System.out.println("Tocando EXIT!");
//				mainMainMenuPrincipal.dispose();
//				Gdx.app.exit();
//			}
//		}
//
//		if (Gdx.input.getX() < 350 + CONFIG_BUTTON_WIDTH && Gdx.input.getX() > 350 && Gdx.input.getY() < 475 + CONFIG_BUTTON_HEIGHT && Gdx.input.getY() > 475) {
//			if (Gdx.input.isTouched()) {
//				System.out.println("Tocando Config!");
//				if (music_conf = false) {
//					music_conf = true;
//				} else {
//					music_conf = false;
//				}
//			}
//		}
//
//		if (Gdx.input.getX() < 150 + PLAY_BUTTON_WIDTH && Gdx.input.getX() > 150 && Gdx.input.getY() < 475 + PLAY_BUTTON_HEIGHT && Gdx.input.getY() > 475) {
//			if (Gdx.input.isTouched()) {
//				System.out.println("Tocando PLAY!");
//				this.dispose();
//				music_conf = false;
//				this.game.setScreen(new GameScreen());
//				start = 1;
//				//game.setScreen(new FasePrincipal(game));
//			}
//		}
//
//		if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
//			if (music_conf) {
//				music_conf = false;
//				//threa_m1.pause();
//				System.out.println("Esc OK!"+ music_conf);
//				// threa_m1.pause();
//			} else {
//				music_conf = true;
//				System.out.println(music_conf);
//				//threa_m1.play();
//			}
//		}
//
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// Sempre que chamar o batch, iniciar com .begin() antes e acabar com .end() no final
		game.getBatch().begin();
		// NUNCA chamar o método .draw() fora do .begin() e .end()
		game.getBatch().draw(bg, 0, 0);
//		game.getBatch().draw(backGround, 0, 0);
//		game.getBatch().draw(playButton, 150, 50, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
//		game.getBatch().draw(configButtonActive, 350, 50, CONFIG_BUTTON_WIDTH, CONFIG_BUTTON_HEIGHT);
//		game.getBatch().draw(exitButtonActive, 550, 50, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
		game.getBatch().end();
		// Para desenhar os botões é necessário o comando da linha abaixo
		game.getBatch().setProjectionMatrix(buttons.getStage().getCamera().combined);
		buttons.getStage().draw();

	} // Fim render

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		// configura o tamanho da tela
		
	} // Fim resize

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		// Pausa o jogo
		
	} // Fim pause

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		// Resume o jogo
		
	} // Fim resume

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		// Quando o jogo está em segundo plano
		
	} // Fim hide

	@Override
	public void dispose() {

		// TODO Auto-generated method stub
		// Livra a memória quando não precisa dos recursos dessa classe
		Gdx.input.setInputProcessor(null);
		buttons.getStage().dispose();

	} // Fim dispose

} // Fim MainMenu