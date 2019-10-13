package me.nebula.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.nebula.game.CyborgDelta;

public class LoadScreen implements Screen {

    private CyborgDelta game;
    private SpriteBatch batch;
    private Texture backGround;


    public LoadScreen(CyborgDelta game){
        this.game = game;
        batch = new SpriteBatch();
        backGround = new Texture("./backgrounds/futuristic-city-wallpaper-3.jpg");

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        //Limpa a tela
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(backGround,0,0);
        batch.end();
        if(Gdx.input.isKeyPressed(Input.Keys.ENTER) || Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            game.setScreen(new Menu(game));
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    backGround.dispose();
    batch.dispose();
    }
}
