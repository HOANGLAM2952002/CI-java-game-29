package entities;

import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;

import java.util.ArrayList;
import java.util.Random;

public class EnemyBlack extends GameObject {
//    private Random rand;
    Random rand = new Random();
    int bullet_cnt = 0;
    public EnemyBlack(){
        this.image = SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
        this.position = new Vector2D((float) Math.random() * 384, 0);
        this.boxCollider = new BoxCollider(this, 28,28);
    }
    @Override
    public void run(){
        this.deactiveIfNeeded();
        /**
         * consider using trigonometry to move Enemy
         */
        if (bullet_cnt >= 20){
            bullet_cnt = 0;
            this.castSpell();
        } else{
            bullet_cnt++;
        }

        this.position.y++;

//        this.y += speed;
    }

    private void castSpell() {
        EnemyBullet newBullet= GameObject.recycle(EnemyBullet.class);
        newBullet.position.x = this.position.x;
        newBullet.position.y = this.position.y;
    }

    public void deactiveIfNeeded(){
        if (this.position.y > 600){
            deActive();
        }
    }

}
