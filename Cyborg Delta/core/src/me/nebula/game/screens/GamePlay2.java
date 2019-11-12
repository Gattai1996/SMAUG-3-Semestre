//package me.nebula.game.screens;
//
//import com.badlogic.gdx.*;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.maps.MapObject;
//import com.badlogic.gdx.maps.objects.RectangleMapObject;
//import com.badlogic.gdx.maps.tiled.TiledMap;
//import com.badlogic.gdx.maps.tiled.TmxMapLoader;
//import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
//import com.badlogic.gdx.math.Rectangle;
//import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.physics.box2d.*;
//import com.badlogic.gdx.utils.viewport.FitViewport;
//import com.badlogic.gdx.utils.viewport.StretchViewport;
//import com.badlogic.gdx.utils.viewport.Viewport;
//
//import me.nebula.game.CyborgDelta;
//import me.nebula.game.bullets.Bullet;
//import me.nebula.game.ground.Ground;
////import me.nebula.game.main.GameMain;
//import me.nebula.game.huds.Hud;
//import me.nebula.game.player.DeltaPlayer;
//import me.nebula.game.player.Player;
//import me.nebula.game.helpers.GameInfo;
//import me.nebula.game.tools.MusicPlayer;
//
//import java.util.ArrayList;
//
//public class GamePlay2 implements Screen {
//
//    private CyborgDelta game;
//
//    private OrthographicCamera mainCamera;
//    private OrthographicCamera box2DCamera;
//    private Box2DDebugRenderer debugRenderer;
//
//    //private Player player;
//    private DeltaPlayer player;
//    private World world;
//
//    private Viewport gameViewport;
//    private Texture background;
//
//    private ArrayList<Bullet> bulletsList;
//    private ArrayList<Bullet> bulletsToRemove;
//    private Hud hud;
//    private TmxMapLoader maploader;
//    private TiledMap map;
//    private OrthogonalTiledMapRenderer renderer;
//
//
//
//    public GamePlay2(CyborgDelta game) {
//
//        this.game = game;
//        mainCamera = new OrthographicCamera();
//        bulletsList = new ArrayList<Bullet>();
//        bulletsToRemove = new ArrayList<Bullet>();
//        hud = new Hud(game.getBatch());
//        maploader = new TmxMapLoader();
//        map = maploader.load("./Mapas/GamePlay.tmx");
//        renderer = new OrthogonalTiledMapRenderer(map, 1 / GameInfo.PPM);
//        gameViewport = new FitViewport(GameInfo.WIDTH / GameInfo.PPM, GameInfo.HEIGHT / GameInfo.PPM, mainCamera);
//        mainCamera.position.set(gameViewport.getWorldWidth() / 2, gameViewport.getWorldHeight() / 2, 0);
//        GameInfo.musicPlay = GameInfo.musicStage;
////        Menu.threa_m1.playMusic();
//
//
//
//
//
//        world = new World(new Vector2(0, -9.8f), true);
//        debugRenderer = new Box2DDebugRenderer();
//
//        BodyDef bdef = new BodyDef();
//        PolygonShape shape = new PolygonShape();
//        FixtureDef fdef = new FixtureDef();
//        Body body;
//
//        for(MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){
//            Rectangle rect = ((RectangleMapObject) object).getRectangle();
//            bdef.type = BodyDef.BodyType.StaticBody;
//            bdef.position.set((rect.getX()+rect.getWidth() / 2) / GameInfo.PPM, (rect.getY() + rect.getHeight() / 2) / GameInfo.PPM);
//            body = world.createBody(bdef);
//            shape.setAsBox(rect.getWidth() / 2 / GameInfo.PPM, rect.getHeight() / 2 / GameInfo.PPM);
//            fdef.shape = shape;
//            body.createFixture(fdef);
//        }
//
//        player = new DeltaPlayer(this);
//        Ground ground = new Ground(world);
//        ground.setSpritePosition(0, 0);
//    } // Fim construtor
//
//    private void handleInput(float deltaTime) {
//        //Definições de fisica do mundo
//        //Ant. Gdx.graphics.getDeltaTime()
//
//
//        // Atirar
////        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT) | Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
////            if(player.facing == "right") {
////                bulletsList.add(new Bullet(player.getX(), player.getY(), 500));
////            } else if (player.facing == "left") {
////                bulletsList.add(new Bullet(player.getX(), player.getY(), -500));
////            }
////
////        }
//        // Mover jogador
//        if (Gdx.input.isKeyPressed(Input.Keys.A) | Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.b2body.getLinearVelocity().x >= 2) {
//            player.b2body.applyLinearImpulse(new Vector2(-0.1f,0), player.b2body.getWorldCenter(), true);
//            mainCamera.position.x -= 100 * deltaTime;
//        } else if (Gdx.input.isKeyPressed(Input.Keys.D) | Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.b2body.getLinearVelocity().x <= 2) {
//            player.b2body.applyLinearImpulse(new Vector2(0.1f,0), player.b2body.getWorldCenter(), true);
//            mainCamera.position.x += 100 * deltaTime;
//        }
//        if (Gdx.input.isKeyJustPressed(Input.Keys.W) | Gdx.input.isKeyPressed(Input.Keys.UP)) {
//            player.b2body.applyLinearImpulse(new Vector2(0, 5f), player.b2body.getWorldCenter(), true);
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
//            System.exit(0);
//        }
//    }
//
//    private void update(float deltaTime) {
//        // deltaTime é o tempo entre um frame e outro
//        handleInput(deltaTime);
//
//        world.step(1/60f, 6, 2);
//        // Update da lista de bullets na tela
//        for(Bullet bullet : bulletsList) {
//            bullet.update(deltaTime);
//            if(bullet.remove) {
//                bulletsToRemove.add(bullet);
//            }
//        }
//        // Remove todas as bullets que estão na lista para serem removidas
//        bulletsList.removeAll(bulletsToRemove);
//        //Movimenta a camera junto do player
//        mainCamera.position.x = player.b2body.getPosition().x;
//
//        //atualiza a camera
//        mainCamera.update();
//        renderer.setView(mainCamera);
//    } // Fim update
//
//    public void create () {
//
//    } // Fim create
//
//    @Override
//    public void show() {
//        // TODO Auto-generated method stub
//
//    } // Fim show
//
//    @Override
//    public void render(float delta) {
//
//        update(delta);
//        // Limpa a tela antes de desenhar os sprites
//        Gdx.gl.glClearColor(0, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        //Gerando o Tmx
//        renderer.render();
//        //Gera Box2d
//        debugRenderer.render(world, mainCamera.combined);
//        game.getBatch().setProjectionMatrix(mainCamera.combined);
//        game.getBatch().begin();
//        player.draw(game.getBatch());
//
//        for(Bullet bullet : bulletsList) {
//            bullet.render(game.getBatch());
//        }
//        game.getBatch().end();
//        //Desenha o HUD das fases
//        game.getBatch().setProjectionMatrix(hud.stage.getCamera().combined);
//        hud.stage.draw();
//
//
//
//
//
//
//
//    } // Fim render
//
//    @Override
//    public void hide() {
//        // TODO Auto-generated method stub
//
//    } // Fim hide
//
//    @Override
//    public void resize(int width, int height) {
//        // TODO Auto-generated method stub
//
//    } // Fim resize
//
//    @Override
//    public void pause() {
//
//    } // Fim pause
//
//    @Override
//    public void resume() {
//
//    } // Fim resume
//
//    @Override
//    public void dispose() {
//        game.dispose();
//
//    } // Fim dispose
//
//    public World getWorld() {
//        return world;
//    }
//} // Fim Gameplay
