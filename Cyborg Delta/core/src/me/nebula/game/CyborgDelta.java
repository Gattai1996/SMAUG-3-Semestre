package me.nebula.game;



import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


import me.nebula.game.screens.Menu;


public class CyborgDelta extends Game {
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		System.out.println("Jogo iniciado");
		this.setScreen(new Menu(this));
	}
	
	@Override
	public void render () {
		super.render();
	}
}
	