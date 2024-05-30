import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class WelcomePanel extends JPanel implements ActionListener {

    private JTextField textField;
    private JButton guessButton;
    private JButton clearButton;
    private JFrame enclosingFrame;
    private BufferedImage background;
    private Clip songClip;

    public WelcomePanel(JFrame frame) {
        enclosingFrame = frame;
        try {
            background = ImageIO.read(new File("src/background.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        textField = new JTextField(20);
        guessButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        add(textField);  // textField doesn't need a listener since nothing needs to happen when we type in text
        add(guessButton);
        add(clearButton);
        guessButton.addActionListener(this);
        clearButton.addActionListener(this);
        playMusic();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Calibri", Font.BOLD, 16));
        g.setColor(Color.WHITE);
        g.drawImage(background, 0, 0, null);
        g.drawString("Please enter your name:", 150, 200);
        textField.setLocation(130, 225);
        guessButton.setLocation(150, 250);
        clearButton.setLocation(250, 250);
    }

    private void playMusic() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/intro.wav").getAbsoluteFile());
            songClip = AudioSystem.getClip();
            songClip.open(audioInputStream);
            songClip.loop(Clip.LOOP_CONTINUOUSLY);  // song repeats when finished
            songClip.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // ACTIONLISTENER INTERFACE METHODS
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == guessButton) {
                String playerName = textField.getText();
                MusicSelectionFrame m = new MusicSelectionFrame();
                enclosingFrame.setVisible(false);
                songClip.stop();
                songClip.close();
            } else {
                textField.setText("");
            }
        }
    }
}
