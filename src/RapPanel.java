import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RapPanel extends JPanel implements ActionListener {

    private JTextField textField;
    private JTextField instruments;
    private JTextField artistBirth;
    private JTextField coverSong;
    private JTextField verse;

    private ArrayList<String> musicFiles;
    private JButton submitButton;
    private JButton playButton;
    private JButton clearButton;
    private JButton skipButton;
    private int guess;
    private JFrame enclosingFrame;
    private BufferedImage background;

    public RapPanel(JFrame frame) {
        enclosingFrame = frame;
        try {
            background = ImageIO.read(new File("src/RapBackground.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        textField = new JTextField(20);
        instruments = new JTextField(20);
        instruments.setText("                         Instrumental");
        instruments.setEditable(false);
        artistBirth = new JTextField(20);
        artistBirth.setText("                      Artist Birth Place");
        artistBirth.setEditable(false);
        coverSong = new JTextField(20);
        coverSong.setText("                           Cover Song");
        coverSong.setEditable(false);
        verse = new JTextField(20);
        verse.setText("                                 Verse");
        verse.setEditable(false);
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        skipButton = new JButton("Skip");
        playButton = new JButton("Play");
        guess = 0;
        add(textField);
        add(submitButton);
        add(clearButton);
        add(playButton);
        add(instruments);
        add(skipButton);
        add(coverSong);
        add(artistBirth);
        add(verse);
        submitButton.addActionListener(this);
        skipButton.addActionListener(this);
        clearButton.addActionListener(this);
        playButton.addActionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Comic Sans", Font.BOLD, 12));
        g.setColor(Color.WHITE);
        g.drawImage(background, 0, 0, null);
        g.drawString("Enter your guess", 200, 385);
        textField.setLocation(140, 400);
        instruments.setLocation(140, 50);
        artistBirth.setLocation(140, 125);
        coverSong.setLocation(140, 200);
        verse.setLocation(140, 275);
        submitButton.setLocation(100, 425);
        clearButton.setLocation(180, 425);
        playButton.setLocation(255,425);
        skipButton.setLocation(330,425);
    }

    // ACTIONLISTENER INTERFACE METHODS
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == submitButton) {
                System.out.println("Enter");
            }else if (button == playButton) {
                System.out.println("Music Played");
            }else if (button == skipButton){
                System.out.println("Section Skipped");
            } else{
                textField.setText("");
            }
        }
    }
}
