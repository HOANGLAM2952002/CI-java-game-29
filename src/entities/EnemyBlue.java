package entities;

import bases.GameObject;
import bases.SpriteUtils;

import java.awt.*;
import java.util.Random;

public class EnemyBlue extends GameObject {
    int move[] = {-5,5};
//    private Random rand;
    Random rand = new Random();
    int speed = 5;

    public EnemyBlue(){
        this.image = SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png");
        this.position.x = rand.nextInt(200);
        this.position.y = rand.nextInt(200);
        this.speed = 5;
    }

    @Override
    public void run(){
        /**
         * consider using trigonometry to move Enemy
         */
        this.position.y++;
//        this.y += speed;

    }
}
