package me.nebula.game.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;
import me.nebula.game.helpers.GameInfo;

public class Player extends Sprite {

    private World world;
    private Body body;
    private boolean jumping;
    public String facing = "right";

    public Player(World world, float x, float y) {
        super(new Texture("Idle.png"));
        this.world = world;
        setPosition(x, y);
        createBody();
    } // Fim construtor

    public Player(Sprite sprite) {
    }

    private void createBody() {

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(getX() / GameInfo.PPM, getY() / GameInfo.PPM);
        body = world.createBody(bodyDef);
        body.setFixedRotation(true);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox((getWidth() / 8f) / GameInfo.PPM,
                (getHeight() / 4f) / GameInfo.PPM);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.density = 4f;
        fixtureDef.friction = 2f;
        fixtureDef.shape = shape;
        Fixture fixture = body.createFixture(fixtureDef);
        shape.dispose();

    } // Fim createBody

    public Player positionThePlayer(Player player) {
        player = new Player(world,  player.getX(), player.getY());
        return player;
    }

    public void movePlayer(float x) {
        body.setLinearVelocity(x, body.getLinearVelocity().y);
    }

    public void jumpPlayer(float y) {
        if(!jumping) {
            body.setLinearVelocity(body.getLinearVelocity().x, y);
        }
    }

    public void drawPlayer(SpriteBatch batch) {
        batch.draw(this, getX() - getWidth() / 2f,
                getY() - getHeight() / 2f);
    }

    public void updatePlayer() {
        if(body.getLinearVelocity().x < 0f && !this.isFlipX()) {
            facing = "left";
            this.flip(true, false);
        } else if (body.getLinearVelocity().x > 0f && this.isFlipX()) {
            facing = "right";
            this.flip(true, false);
        }
        // Checa a velocidade y para determinar se está pulando
        if(body.getLinearVelocity().y != 0) {
            jumping = true;
        } else {
            jumping = false;
        }
        // Ajusta a posição do corpo e o sprite
        setPosition(body.getPosition().x * GameInfo.PPM - 580, body.getPosition().y * GameInfo.PPM - 310);
    }

} // Fim Player