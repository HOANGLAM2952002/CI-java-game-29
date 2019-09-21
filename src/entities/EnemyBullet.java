package entities;

import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;

import javax.swing.*;
import java.awt.*;

public class EnemyBullet extends GameObject {
    int bullet_cnt = 0;
    public EnemyBullet(){
        this.image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        this.position = new Vector2D();
        this.boxCollider = new BoxCollider(this, 16, 16);
    }

    public void run(){
        this.deactiveIfNeeded();
        this.position.y += 5;
        Player player = GameObject.checkCollider(this, Player.class);
        if (player != null){
            System.out.println("dang va cham");
            player.deActive();
            this.deActive();
        }
    }

    public void deactiveIfNeeded(){
        if (this.position.y > 600){
            deActive();
        }
    }
}
