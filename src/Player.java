import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Player {
    Image image;
    int x = 175;
    int y = 500;

    long cnt = 0;
    ArrayList<PlayerSpell> playerSpells;


    public Player(){
        this.image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.x = 175;
        this.y = 500;
        this.cnt = 0;
        playerSpells = new ArrayList<>();
    }

    /**
     * run function run() of each spell
     * @param g
     */
    public void render(Graphics g) {
        g.drawImage(this.image, x, y, null);
        for (int i = 0; i < this.playerSpells.size(); i++){
            PlayerSpell playerSpell = this.playerSpells.get(i);
            playerSpell.render(g);
        }
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

        if (KeyPressed.getInstance().shootPresed && cnt >= 20){
            this.castSpell();
            cnt = 0;
        } else {
            cnt++;
        }

        this.x = Utils.clamp(this.x, 0, 384 - 44);
        this.y = Utils.clamp(this.y, 0, 600 - 100);

        for (int i = 0; i < this.playerSpells.size(); i++){
            PlayerSpell playerSpell = this.playerSpells.get(i);
            playerSpell.run();
        }
    }

    /**
     * create a new spell
     * set original x,y the same with player
     * add into array list playerSpells
     */
    private void castSpell() {
        PlayerSpell newSpell = new PlayerSpell();
        newSpell.x = this.x;
        newSpell.y = this.y;
        playerSpells.add(newSpell);
    }
}

