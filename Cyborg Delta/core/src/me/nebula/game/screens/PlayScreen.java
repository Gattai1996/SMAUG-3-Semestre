package me.nebula.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import me.nebula.game.CyborgDelta;
import me.nebula.game.helpers.GameInfo;
import me.nebula.game.huds.Hud;

public class PlayScreen implements Screen {
    private CyborgDelta game;
    private OrthographicCamera gamecam;
    private Hud hud;
    private TmxMapLoader maploader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    //Box2D Variaveis
    private World world;
    private Box2DDebugRenderer b2dr;

    public PlayScreen(CyborgDelta game) {
        this.game = game;
        //Cria a camera que ira seguir o player
        gamecam = new OrthographicCamera();
        //Determina o campo
//        gamePort = new FitViewport(GameInfo.WIDTH, GameInfo.HEIGHT. gamecam);

        //Cria o HUD
        hud = new Hud(game.getBatch());

        //Carrega o mapa
        maploader = new TmxMapLoader();
        map = maploader.load("./Mapas/GamePlay.tmx");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

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

    }
}
