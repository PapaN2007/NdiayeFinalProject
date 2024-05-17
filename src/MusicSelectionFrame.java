import javax.swing.*;

public class MusicSelectionFrame {
    private MusicSelectionPanel panel;

    public MusicSelectionFrame() {
        JFrame frame = new JFrame("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        panel = new MusicSelectionPanel(frame);
        frame.add(panel);
        frame.setVisible(true);
    }
}
