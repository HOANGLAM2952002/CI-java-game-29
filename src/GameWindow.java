import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameWindow extends JFrame {
    GameCanvas canvas = new GameCanvas();

    public GameWindow(){
        this.setResizable(false);
        this.setSize(384, 600);

        this.setContentPane(this.canvas);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


    }
}
