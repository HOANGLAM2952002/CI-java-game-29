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
            if (this.y > 300) {
                this.y -= 5;
            }
        }
        if (KeyPressed.getInstance().downPressed){
            if (this.y < 500){
                this.y += 5;
            }
        }
        if (KeyPressed.getInstance().rightPressed){
            if (this.x < 340){
                this.x += 5;
            }
        }
        if (KeyPressed.getInstance().leftPressed){
            if (this.x > 0){
                this.x -= 5;
            }
        }
    }
}

