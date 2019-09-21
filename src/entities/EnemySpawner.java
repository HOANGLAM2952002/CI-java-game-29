package entities;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;

public class EnemySpawner extends GameObject {
    FrameCounter frameCounter;

    public EnemySpawner(){
        frameCounter = new FrameCounter(100);
    }
    @Override
    public void run(){
        if (frameCounter.expired){
            EnemyBlack newEnemyBlack = GameObject.recycle(EnemyBlack.class);
            newEnemyBlack.position = new Vector2D((float) Math.random() * 384, 0);
            frameCounter.reset();
        } else {
            frameCounter.run();
        }
    }
}
