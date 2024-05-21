import javax.swing.*;

public class WinFrame {
    private WinPanel panel;

    public WinFrame() {
        JFrame frame = new JFrame("Win");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        panel = new WinPanel(frame);
        frame.add(panel);
        frame.setVisible(true);
    }
}
