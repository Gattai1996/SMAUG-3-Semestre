//package me.nebula.game.player;
//
//import com.badlogic.gdx.graphics.g2d.Animation;
//import com.badlogic.gdx.graphics.g2d.Sprite;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.badlogic.gdx.physics.box2d.*;
//import me.nebula.game.helpers.GameInfo;
//import me.nebula.game.screens.GamePlay2;
//
//public class DeltaPlayer extends Sprite {
//    public enum State { FALLING, JUMPING, STANDING, RUNNING, DEAD };
//    public State currentState;
//    public State previousState;
//
//    public World world;
//    public Body b2body;
//
//    private TextureRegion cdeltaStand;
//    private Animation cdeltaRun;
//    private TextureRegion cdeltaJump;
//    private TextureRegion cdeltaDead;
//
//
//    private float stateTimer;
//    private boolean runningRight;
//    private boolean marioIsDead;
//    private GamePlay2 screen;
//
////    private Array<FireBall> fireballs;
//
//    public DeltaPlayer(World world){
//        this.world = world;
//        defineDeltaPlayer();
//    }
//    public void defineDeltaPlayer(){
//        BodyDef bdef = new BodyDef();
//        bdef.position.set(32 / GameInfo.PPM,32 / GameInfo.PPM);
//        bdef.type = BodyDef.BodyType.DynamicBody;
//        b2body = world.createBody(bdef);
//
//        FixtureDef fdef = new FixtureDef();
//        CircleShape shape = new CircleShape();
//        shape.setRadius(5 / GameInfo.PPM);
//
//        fdef.shape = shape;
//        b2body.createFixture(fdef);
//    }
//    public TextureRegion getFrame(float dt){
//        //get marios current state. ie. jumping, running, standing...
//        currentState = getState();
//
//        TextureRegion region;
//
//        //depending on the state, get corresponding animation keyFrame.
//        switch(currentState){
//            case DEAD:
//                region = marioDead;
//                break;
//            case GROWING:
//                region = growMario.getKeyFrame(stateTimer);
//                if(growMario.isAnimationFinished(stateTimer)) {
//                    runGrowAnimation = false;
//                }
//                break;
//            case JUMPING:
//                region = marioIsBig ? bigMarioJump : marioJump;
//                break;
//            case RUNNING:
//                region = marioIsBig ? bigMarioRun.getKeyFrame(stateTimer, true) : marioRun.getKeyFrame(stateTimer, true);
//                break;
//            case FALLING:
//            case STANDING:
//            default:
//                region = marioIsBig ? bigMarioStand : marioStand;
//                break;
//        }
//}
