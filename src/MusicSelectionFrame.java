import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class MusicSelectionFrame {
    private MusicSelectionPanel panel;

    public MusicSelectionFrame(){
        JFrame frame = new JFrame("Heardle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        panel = new MusicSelectionPanel(frame);
        frame.add(panel);
        frame.setVisible(true);
    }
}
