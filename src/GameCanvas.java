import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GameCanvas extends JPanel {
    Random rand = new Random();

    Background background;
    Player player;

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

        this.background = new Background();
        this.player = new Player();
        // load image
        try {
            // try to catch read phrase
            this.enemyblackStraight = ImageIO.read(new File("assets/images/enemies/level0/black/0.png"));
            this.enemyBlueStraight = ImageIO.read(new File("assets/images/enemies/level0/blue/0.png"));
            this.enemyPinkStraight = ImageIO.read(new File("assets/images/enemies/level0/pink/0.png"));
        } catch (IOException e) {
            // print errors if try wrong
            e.printStackTrace();
        }

        this.keyListener();
    }

    private void keyListener() {
        this.setFocusable(true);
        // catch event clicking buttons
        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    /**
                     * get static from KeyPressed
                     */
                    KeyPressed.getInstance().upPressed = true;
                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    KeyPressed.getInstance().downPressed = true;
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    KeyPressed.getInstance().rightPressed = true;
                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    KeyPressed.getInstance().leftPressed = true;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    KeyPressed.getInstance().upPressed = false;
                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    KeyPressed.getInstance().downPressed = false;
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    KeyPressed.getInstance().rightPressed = false;
                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    KeyPressed.getInstance().leftPressed = false;
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 600, 600);
        this.background.render(g);
        this.player.render(g);
        g.drawImage(this.enemyblackStraight, enemyX, enemyY, null);
        g.drawImage(this.enemyBlueStraight,enemyblueX, enemyblueY,null);
        g.drawImage(this.enemyPinkStraight, enemypinkX, enemypinkY, null);
    }

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

        if (enemypinkX == 100){
            enemypinkX += move[1];
        }
        if (enemypinkX == 250){
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

    public void run() {
        this.background.run();

        /**
         * input keyPressed into player
         */
        this.player.run();
        this.enemyMove();
    }
}
