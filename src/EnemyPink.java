import java.awt.*;
import java.util.Random;

public class EnemyPink {
    int move[] = {-5,5};
    Image image;
    Image state0;
    Image state1;
    Image state2;
//    private Random rand;
    Random rand = new Random();
    int x = rand.nextInt(200);
    int y = rand.nextInt(200);
    int speed = 5;

    public EnemyPink(){
        this.image = SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png");
        this.x = rand.nextInt(200);
        this.y = rand.nextInt(200);
    }

    public void render(Graphics g){
        g.drawImage(this.image, x, y, null);
    }

    public void run(){
        /**
         * consider using trigonometry to move Enemy
         */
        if (x == 100){
            x += move[1];
        }
        if (x == 250){
            x += move[0];
        }
        if (y == 0){
            y += move[1];
        }
        if (y == 400){
            y += move[0];
        }
        x += move[rand.nextInt(2)];
        y += move[rand.nextInt(2)];

//        this.y += speed;
    }
}
