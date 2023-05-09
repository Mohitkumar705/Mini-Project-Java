import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RacingCarGame extends JPanel implements KeyListener {
    private static final long serialVersionUID = 1L;
    private int carX = 150;
    private int carY = 300;

    public RacingCarGame() {
        JFrame frame = new JFrame("Racing Car Game");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setVisible(true);
        frame.addKeyListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 400, 400);
        g.setColor(Color.RED);
        g.fillRect(carX, carY, 50, 50);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT && carX > 0) {
            carX -= 10;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && carX < 350) {
            carX += 10;
        } else if (e.getKeyCode() == KeyEvent.VK_UP && carY > 0) {
            carY -= 10;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN && carY < 350) {
            carY += 10;
        }
        repaint();
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        new RacingCarGame();
    }
}
