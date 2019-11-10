package me.nebula.game.chars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite {
    private TiledMapTileLayer collisionLayer;
    private Vector2 velocity = new Vector2();
    private float speed = 60*2, gravity = 60*1.8f;

    //TiledMapTileLayer collisionLayer
    public Player(Sprite sprite){
        super(sprite);
        this.collisionLayer = collisionLayer;
    }
    public void draw(SpriteBatch spriteBatch) {
        update(Gdx.graphics.getDeltaTime());
        super.draw(spriteBatch);
    }

    private void update(float delta) {
        velocity.y -= gravity * delta;
        if(velocity.y > speed){
            velocity.y = speed;
        }else if (velocity.y < speed){
            velocity.y = -speed;
        }
//        float oldX = getX() + velocity.x * delta,  tileWidth = collisionLayer.getTileWidth(), tileHeight = collisionLayer.getTileHeight();
//        boolean collisionX = false, collisionY = false;
        setX(getX() + velocity.x * delta);
//        if (velocity.x < 0){
//            //top
//            collisionX = collisionLayer.getCell((int) (getX() / tileWidth),(int) ((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("Plataformas");
//
//            //middle
//            if (!collisionX) {
//                collisionX = collisionLayer.getCell((int) (getX() / tileWidth), (int) ((getY() + getHeight() / 2) / tileHeight)).getTile().getProperties().containsKey("Plataformas");
//            }
//            //bottom
//            if (!collisionX) {
//                collisionX = collisionLayer.getCell((int) (getX() / tileWidth), (int) (getY() / tileHeight)).getTile().getProperties().containsKey("Plataformas");
//            }
//
//
//        }
        setY(getY() + velocity.y * delta);
    }

}
