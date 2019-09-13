import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Background {
    Image image;
    int x;
    int y = 600 - 3109;

    /**
     * Contractor load image
     */
    public Background(){
        this.image = SpriteUtils.loadImage("assets/images/background/0.png");
        // background
        this.x = 0;
        this.y = 600 - 3109;
    }

    /**
     * Render image
     * @param g
     */
    public void render(Graphics g) {
        g.drawImage(this.image, x, y, null);
    }

    /**
     * Handle background logic
     */
    public void run() {
        if (y < 0){
            y += 10;
        } else {
            y = 600 - 3109;
        }
    }
}

