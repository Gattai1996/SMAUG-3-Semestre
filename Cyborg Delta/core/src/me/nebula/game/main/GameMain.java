package me.nebula.game.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.nebula.game.helpers.GameInfo;
import me.nebula.game.screens.MainMenu;


public class GameMain extends Game {
	// Tamanho da tela
	private static final int WIDTH = GameInfo.WIDTH;
	private static final int HEIGHT = GameInfo.HEIGHT;
	private SpriteBatch batch;

	@Override
	public void create () {
		// O create inicia tudo no jogo
		batch = new SpriteBatch();
		// Tudo que é desenhado na tela usa o batch. NUNCA criar outro SriteBatch em outra classe, pois acaba com a performace do jogo
		System.out.println("Jogo iniciado com sucesso");
		// A tela inicial é o menu
		setScreen(new MainMenu(this));
	} // Fim create
	
	@Override
	public void render () {
		// É necessário chamar esse método que desenha na tela e atualiza para funcionar em outras screens, como o menu
		super.render();
	} // Fim render

	public SpriteBatch getBatch() {
		// Getter do batch
		return this.batch;
	} // Fim do getBatch

} // Fim GameMain
	