import javax.swing.*;

public class RapFrame {
    private RapPanel panel;

    public RapFrame() {
        JFrame frame = new JFrame("Rap Version");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        panel = new RapPanel(frame);
        frame.add(panel);
        frame.setVisible(true);
    }
}
