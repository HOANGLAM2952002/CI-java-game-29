import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Player {
    Image image;
    int x = 175;
    int y = 500;

    public Player(){
        this.image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.x = 175;
        this.y = 500;
    }

    public void render(Graphics g) {
        g.drawImage(this.image, x, y, null);
    }

    /**
     * input keyPressed from GameCanvas
     * @param keyPressed (no need)
     */
    public void run() {
        if (KeyPressed.getInstance().upPressed){
            this.y -= 5;
        }
        if (KeyPressed.getInstance().downPressed){
            this.y += 5;
        }
        if (KeyPressed.getInstance().rightPressed){
            this.x += 5;
        }
        if (KeyPressed.getInstance().leftPressed){
            this.x -= 5;
        }

        this.x = Utils.clamp(this.x, 0, 384 - 44);
        this.y = Utils.clamp(this.y, 0, 600 - 100);


    }
}

