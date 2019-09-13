import java.awt.*;

public class PlayerSpell {
    Image image;
    Player player = new Player();
    int x;
    int y;

    public PlayerSpell(){
        this.image = SpriteUtils.loadImage("assets/images/player-spells/a/0.png");
        this.x = player.x;
        this.y = player.y;
    }

    public void render(Graphics g){
        g.drawImage(this.image, x, y, null);
    }

    public void run() {
        this.y -= 5;
    }
}
