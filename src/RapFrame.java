import javax.swing.*;

public class RapFrame implements Runnable{
    private RapPanel panel;

    public RapFrame() {
        JFrame frame = new JFrame("Rap Version");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        panel = new RapPanel(frame);
        frame.add(panel);
        frame.setVisible(true);
        Thread thread = new Thread(this);
        thread.start();
    }

    public void run() {
        while (true) {
            panel.repaint();  // we don't ever call "paintComponent" directly, but call this to refresh the panel
        }
    }
}
