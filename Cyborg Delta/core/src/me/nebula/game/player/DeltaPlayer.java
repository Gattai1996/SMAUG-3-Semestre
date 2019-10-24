package me.nebula.game.player;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;
import me.nebula.game.screens.GamePlay2;

public class DeltaPlayer extends Sprite {
    private  GamePlay2 screen;
    public World world;
    public Body b2body;

    public DeltaPlayer (GamePlay2 screen){
        this.screen = screen;
        this.world = screen.getWorld();
        defineDeltaPlayer();
    }
    public void defineDeltaPlayer(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(32,32);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);
        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5);

        fdef.shape = shape;
        b2body.createFixture(fdef);
    }

}
