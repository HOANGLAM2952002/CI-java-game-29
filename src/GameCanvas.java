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
    EnemyBlack enemyBlack;
    EnemyBlue enemyBlue;
    EnemyPink enemyPink;

    PlayerSpell playerSpell;



    int move[] = {-5,5};


    public GameCanvas(){

        this.background = new Background();
        this.player = new Player();
        this.enemyBlack = new EnemyBlack();
        this.enemyBlue = new EnemyBlue();
        this.enemyPink = new EnemyPink();

        this.playerSpell = new PlayerSpell();
        this.playerSpell.x = this.player.x;
        this.playerSpell.y = this.player.y;
//        // load image
//        try {
//            // try to catch read phrase
//        } catch (IOException e) {
//            // print errors if try wrong
//            e.printStackTrace();
//        }

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
        this.enemyBlack.render(g);
        this.enemyBlue.render(g);
        this.enemyPink.render(g);

        this.playerSpell.render(g);
    }


    public void run() {
        this.background.run();

        /**
         * input keyPressed into player
         */
        this.player.run();
        this.enemyBlack.run();
        this.enemyBlue.run();
        this.enemyPink.run();

        this.playerSpell.run();
    }
}
