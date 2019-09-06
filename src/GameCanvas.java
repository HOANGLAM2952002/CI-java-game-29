import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 600, 600);
    }
}
