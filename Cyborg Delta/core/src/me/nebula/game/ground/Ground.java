package me.nebula.game.ground;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;
import me.nebula.game.helpers.GameInfo;

public class Ground extends Sprite {

    private World world;
    private Body body;

    public Ground(World world){
        this.world = world;
    }

    private void createBody() {

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(0f / GameInfo.PPM, 0f / GameInfo.PPM);
        body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(1280f / GameInfo.PPM, 20f / GameInfo.PPM);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        Fixture fixture = body.createFixture(fixtureDef);
        shape.dispose();

    } // Fim createBody

    public void setSpritePosition(float x, float y) {
        setPosition(x, y);
        createBody();
    }

} // Fim Ground
