import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {
    Image background;
    Image playerStraight;
    public GameCanvas(){
        // load image
        try {
            // try to catch read phrase
            this.background = ImageIO.read(new File("assets/images/background/0.png"));
            this.playerStraight = ImageIO.read(new File("assets/images/players/straight/0.png"));
        } catch (IOException e) {
            // print errors if try wrong
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 600, 600);
        g.drawImage(this.background, 0, 0, null);
        g.drawImage(this.playerStraight, 175, 500, null);

    }
}
