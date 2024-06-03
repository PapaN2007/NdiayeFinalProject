import javax.swing.*;

public class LoseFrame implements Runnable{
    private LosePanel panel;

    public LoseFrame() {
        JFrame frame = new JFrame("Lose");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        panel = new LosePanel(frame);
        frame.add(panel);
        frame.setVisible(true);
        Thread thread = new Thread(this);
        thread.start();
    }

    // Runnable interface method
    public void run() {
        while (true) {
            panel.repaint();  // don't call paintComponent directly
        }
    }
}
