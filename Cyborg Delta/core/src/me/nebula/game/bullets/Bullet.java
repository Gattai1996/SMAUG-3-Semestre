package me.nebula.game.bullets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.nebula.game.helpers.GameInfo;

public class Bullet {

    private static Texture texture;
    private float x, y, s;
    public boolean remove = false;

    public Bullet(float x, float y, float s) {
        this.s = s;
        this.x = x;
        this.y = y;
        texture = new Texture("bullet.png");

    }

    public void update(float deltaTime) {

        x += s * deltaTime;
        if(x >= GameInfo.WIDTH) {
            remove = true;
        }

    }

    public void render(SpriteBatch batch) {

        batch.draw(texture, x, y);

    }

}
