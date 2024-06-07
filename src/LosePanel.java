import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class LosePanel extends JPanel{

    private JTextField textField;
    private BufferedImage background;
    private JFrame enclosingFrame;
    private double stringX;
    private Clip songClip;



    public LosePanel(JFrame frame) {
        enclosingFrame = frame;
        stringX = 180;
        try {
            background = ImageIO.read(new File("src/sadbackground.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        textField = new JTextField("Congrats You Won!!!!!");
        playMusic();

    }
    private void playMusic() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/sadoutro.wav").getAbsoluteFile());
            songClip = AudioSystem.getClip();
            songClip.open(audioInputStream);
            songClip.loop(Clip.LOOP_CONTINUOUSLY);  // song repeats when finished
            songClip.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        stringX += 0.05;
        if (stringX > 500) {
            stringX = 0;
        }
        super.paintComponent(g);
        g.setFont(new Font("Calibri", Font.BOLD, 16));
        g.setColor(Color.WHITE);
        g.drawImage(background, 0, 0, null);
        g.drawString("Unfortunately You Have Lost :( :( :(", (int) stringX,225);
    }
}


