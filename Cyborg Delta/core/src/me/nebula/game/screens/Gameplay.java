package me.nebula.game.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import me.nebula.game.CyborgDelta;
import me.nebula.game.bullets.Bullet;
import me.nebula.game.ground.Ground;
//import me.nebula.game.main.GameMain;
import me.nebula.game.huds.Hud;
import me.nebula.game.player.Player;
import me.nebula.game.helpers.GameInfo;
import me.nebula.game.tools.MusicPlayer;

import java.util.ArrayList;

public class Gameplay implements Screen {

    private CyborgDelta game;

    private OrthographicCamera mainCamera;
    private OrthographicCamera box2DCamera;
    private Box2DDebugRenderer debugRenderer;

    private Player player;
    private World world;

    private Viewport gameViewport;
    private Texture background;

    private ArrayList<Bullet> bulletsList;
    private ArrayList<Bullet> bulletsToRemove;
    private Hud hud;


    public Gameplay(CyborgDelta game) {

        bulletsList = new ArrayList<Bullet>();
        bulletsToRemove = new ArrayList<Bullet>();
        hud = new Hud(game.getBatch());

        world = new World(new Vector2(0, - 9.8f), true);
        Ground ground = new Ground(world);
        ground.setSpritePosition(0, 0);


        this.game = game;

        background = new Texture("Mapas/Menu.png");

        mainCamera = new OrthographicCamera(GameInfo.WIDTH , GameInfo.HEIGHT);
        mainCamera.position.set(GameInfo.WIDTH / 2f, GameInfo.HEIGHT / 2f, 0);

        gameViewport = new StretchViewport(GameInfo.WIDTH, GameInfo.HEIGHT,
                mainCamera);

//        box2DCamera = new OrthographicCamera();
//        box2DCamera.setToOrtho(false, GameInfo.WIDTH / GameInfo.PPM,
//                GameInfo.HEIGHT / GameInfo.PPM);
//        box2DCamera.position.set(GameInfo.WIDTH / 2f, GameInfo.HEIGHT / 2f, 0);

//        debugRenderer = new Box2DDebugRenderer();




        player = new Player(world, GameInfo.WIDTH / 2f, 1000);
//        player = player.positionThePlayer(player);
//        world.setContactListener((ContactListener) this);


    } // Fim construtor

    private void handleInput(float deltaTime) {
        // Pausar música

        if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            System.out.println(GameInfo.pauseMusic);
            if (!GameInfo.pauseMusic) {
                GameInfo.pauseMusic = true;

            } else {
                GameInfo.pauseMusic = false;
            }
        }
        // Atirar
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT) | Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            if(player.facing == "right") {
                bulletsList.add(new Bullet(player.getX(), player.getY(), 500));
            } else if (player.facing == "left") {
                bulletsList.add(new Bullet(player.getX(), player.getY(), -500));
            }

        }
        // Mover jogador
        if (Gdx.input.isKeyPressed(Input.Keys.A) | Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.movePlayer(-2f);
        } else if (Gdx.input.isKeyPressed(Input.Keys.D) | Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.movePlayer(2f);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.W) | Gdx.input.isKeyPressed(Input.Keys.UP)) {
            player.jumpPlayer(5f);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            System.exit(0);
        }
    }

    private void update(float deltaTime) {
        // deltaTime é o tempo entre um frame e outro
        handleInput(deltaTime);
        // Update da lista de bullets na tela
        for(Bullet bullet : bulletsList) {
            bullet.update(deltaTime);
            if(bullet.remove) {
                bulletsToRemove.add(bullet);
            }
        }
        // Remove todas as bullets que estão na lista para serem removidas
        bulletsList.removeAll(bulletsToRemove);
        //Segue Personagem Camera
        moveCamera();
    } // Fim update

    private void moveCamera() {
        mainCamera.position.y -= 1;
    }

    public void create () {

    } // Fim create

    @Override
    public void show() {
        // TODO Auto-generated method stub

    } // Fim show

    @Override
    public void render(float delta) {

        update(delta);
        // Limpa a tela antes de desenhar os sprites
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Desenha o HUD das fases
//        game.getBatch().setProjectionMatrix(hud.stage.getCamera().combined);
//        hud.stage.draw();

        game.getBatch().begin();
        game.getBatch().draw(background, 0 - GameInfo.PPM / 2f - background.getWidth() / 2f + 50,
                0 - GameInfo.PPM / 2f - background.getHeight() / 2f + 50);
        player.drawPlayer(game.getBatch());
        // Desenha na tela as bullets
        for(Bullet bullet : bulletsList) {
            bullet.render(game.getBatch());
        }
        game.getBatch().end();

//        debugRenderer.render(world, box2DCamera.combined);
        game.getBatch().setProjectionMatrix(mainCamera.combined);

        player.updatePlayer();
        world.step(Gdx.graphics.getDeltaTime(), 6, 2);

    } // Fim render

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    } // Fim hide

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    } // Fim resize

    @Override
    public void pause() {

    } // Fim pause

    @Override
    public void resume() {

    } // Fim resume

    @Override
    public void dispose() {
        game.dispose();

    } // Fim dispose

} // Fim Gameplay