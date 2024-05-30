import javax.swing.*;

public class WinFrame implements Runnable{
    private WinPanel panel;

    public WinFrame() {
        JFrame frame = new JFrame("Win");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        panel = new WinPanel(frame);
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
