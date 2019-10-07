package me.nebula.game.huds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import me.nebula.game.main.GameMain;
import me.nebula.game.helpers.GameInfo;
import me.nebula.game.screens.Gameplay;

public class MainMenuButtons {

    private GameMain game;
    private Stage stage;
    private Viewport gameViewport;
    private ImageButton playButton, quitButton, musicButton;

    public MainMenuButtons(GameMain game) {
        this.game = game;
        gameViewport = new FitViewport(GameInfo.WIDTH, GameInfo.HEIGHT,
                 new OrthographicCamera());
        stage = new Stage(gameViewport, game.getBatch());
        Gdx.input.setInputProcessor(stage);
        createAndPositionButtons();
        stage.addActor(playButton);
        stage.addActor(quitButton);
        stage.addActor(musicButton);
        addAllListenners();
    }

    private void createAndPositionButtons() {
        playButton = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("Buttons/play.png"))));
        quitButton = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("Buttons/quit.png"))));
        musicButton = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("Buttons/music.png"))));
        playButton.setPosition(GameInfo.WIDTH / 2f, GameInfo.HEIGHT / 2f + 100, Align.center);
        quitButton.setPosition(GameInfo.WIDTH / 2f, GameInfo.HEIGHT / 2f - 100, Align.center);
        musicButton.setPosition(GameInfo.WIDTH - 300, 10);
    } // Fim createAndPositionButtons

    private void addAllListenners() {
        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Botão Jogar clicado");
                game.setScreen(new Gameplay(game));
            }
        });
        quitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Botão Sair clicado");
            }
        });
        musicButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Botão Música clicado");
            }
        });
    }

    public Stage getStage() {
        return this.stage;
    } // Fim getter

} // Fim MainMenuButtons
