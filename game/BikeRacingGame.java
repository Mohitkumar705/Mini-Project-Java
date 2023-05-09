import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BikeRacingGame extends JFrame implements KeyListener {
    private int x = 100, y = 100; // player position
    private int dx = 0, dy = 0; // player velocity

    public BikeRacingGame() {
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bike Racing Game");
        setResizable(false);
        setVisible(true);
        addKeyListener(this);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillRect(x, y, 50, 50);
    }

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            dx = -5;
        } else if (code == KeyEvent.VK_RIGHT) {
            dx = 5;
        } else if (code == KeyEvent.VK_UP) {
            dy = -5;
        } else if (code == KeyEvent.VK_DOWN) {
            dy = 5;
        }
    }

    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_RIGHT) {
            dx = 0;
        } else if (code == KeyEvent.VK_UP || code == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

    public void update() {
        x += dx;
        y += dy;
        repaint();
    }

    public static void main(String[] args) {
        BikeRacingGame game = new BikeRacingGame();
        while (true) {
            game.update();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
        }
    }
}

