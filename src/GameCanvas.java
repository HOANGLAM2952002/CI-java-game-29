import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GameCanvas extends JPanel {
    Random rand = new Random();

    Image background;
    int backgroundX = 0;
    int backgroundY = 0;

    Image playerStraight;
    int playerX = 175;
    int playerY = 500;

    Image enemyblackStraight;
    int enemyX = rand.nextInt(200);
    int enemyY = rand.nextInt(200);

    Image enemyBlueStraight;
    int enemyblueX = rand.nextInt(200);
    int enemyblueY = rand.nextInt(200);

    Image enemyPinkStraight;
    int enemypinkX = rand.nextInt(200);
    int enemypinkY = rand.nextInt(200);

    int move[] = {-5,5};


    public GameCanvas(){
        // load image
        try {
            // try to catch read phrase
            this.background = ImageIO.read(new File("assets/images/background/0.png"));
            this.playerStraight = ImageIO.read(new File("assets/images/players/straight/0.png"));
            this.enemyblackStraight = ImageIO.read(new File("assets/images/enemies/level0/black/0.png"));
            this.enemyBlueStraight = ImageIO.read(new File("assets/images/enemies/level0/blue/0.png"));
            this.enemyPinkStraight = ImageIO.read(new File("assets/images/enemies/level0/pink/0.png"));
        } catch (IOException e) {
            // print errors if try wrong
            e.printStackTrace();
        }

        this.playerX = 175;
        this.playerY = 500;

        this.setFocusable(true);
        // catch event clicking buttons
        this.addKeyListener(new KeyAdapter() {

            public void enemyMove(){
                if (enemyX == 0){
                    enemyX += move[1];
                }
                if (enemyX == 384){
                    enemyX += move[0];
                }
                if (enemyY == 0){
                    enemyY += move[1];
                }
                if (enemyY == 400){
                    enemyY += move[0];
                }
                enemyX += move[rand.nextInt(2)];
                enemyY += move[rand.nextInt(2)];

                if (enemyblueX == 0){
                    enemyblueX += move[1];
                }
                if (enemyblueX == 384){
                    enemyblueX += move[0];
                }
                if (enemyblueY == 0){
                    enemyblueY += move[1];
                }
                if (enemyblueY == 400){
                    enemyblueY += move[0];
                }
                enemyblueX += move[rand.nextInt(2)];
                enemyblueY += move[rand.nextInt(2)];

                if (enemypinkX == 0){
                    enemypinkX += move[1];
                }
                if (enemypinkX == 384){
                    enemypinkX += move[0];
                }
                if (enemypinkY == 0){
                    enemypinkY += move[1];
                }
                if (enemypinkY == 400){
                    enemypinkY += move[0];
                }
                enemypinkX += move[rand.nextInt(2)];
                enemypinkY += move[rand.nextInt(2)];
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    if (playerY != 0){
                        playerY -= 5;
                        this.enemyMove();
                    }
                    backgroundY -= 5;
                    this.enemyMove();
                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    if (playerY != 500){
                        playerY += 5;
                        this.enemyMove();
                    }
                    backgroundY -= 5;
                    this.enemyMove();
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    if (playerX != 350){
                        playerX += 5;
                        this.enemyMove();
                    } else {
                        playerX = -10;
                        this.enemyMove();
                    }
                    backgroundY -= 5;
                    this.enemyMove();
                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    if (playerX != -10){
                        playerX -= 5;
                        this.enemyMove();
                    } else {
                        playerX = 350;
                        this.enemyMove();
                    }
                    backgroundY -= 5;
                    this.enemyMove();
                }

                if (backgroundY == -2500){
                    backgroundY = 0;
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
        g.drawImage(this.background, backgroundX, backgroundY, null);
        g.drawImage(this.playerStraight, playerX, playerY, null);
        g.drawImage(this.enemyblackStraight, enemyX, enemyY, null);
        g.drawImage(this.enemyBlueStraight,enemyblueX, enemyblueY,null);
        g.drawImage(this.enemyPinkStraight, enemypinkX, enemypinkY, null);
    }

    public void run() {

    }
}
