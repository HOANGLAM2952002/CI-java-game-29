import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {
    Image background;

    Image player;
    int playerX = 175;
    int playerY = 500;

    public GameCanvas(){
        // load image
        try {
            // try to catch read phrase
            this.background = ImageIO.read(new File("assets/images/background/0.png"));
            this.player = ImageIO.read(new File("assets/images/players/straight/0.png"));
        } catch (IOException e) {
            // print errors if try wrong
            e.printStackTrace();
        }

        this.playerX = 175;
        this.playerY = 500;

        this.setFocusable(true);
        // catch event clicking buttons
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    playerY -= 5;
                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    playerY += 5;
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    playerX += 5;
                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    playerX -= 5;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 600, 600);
        g.drawImage(this.background, 0, 0, null);
        g.drawImage(this.player, playerX, playerY, null);

    }

    public void run() {
        System.out.println("game loop");
    }
}
