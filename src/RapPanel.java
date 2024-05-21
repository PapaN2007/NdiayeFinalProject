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
import java.util.ArrayList;

public class RapPanel extends JPanel implements ActionListener {

    private JTextField textField;
    private JTextField instruments;
    private JTextField artistBirth;
    private JTextField coverSong;
    private JTextField verse;
    private JTextField current;
    private Clip songClip;

    private ArrayList<String> musicFiles;
    private ArrayList<String> song1;
    private ArrayList<String> song2;
    private ArrayList<String> song3;
    private ArrayList<String> song4;


    private JButton guessButton;
    private JButton playButton;
    private JButton clearButton;
    private JButton skipButton;
    private int guess;
    private JFrame enclosingFrame;
    private String songName;
    private BufferedImage background;
    private int count;

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
        instruments.setBackground(Color.GREEN);
        instruments.setEditable(false);
        artistBirth = new JTextField(20);
        artistBirth.setText("                      Artist Birth Place");
        artistBirth.setEditable(false);
        coverSong = new JTextField(20);
        coverSong.setText("                        Medieval Remix");
        coverSong.setEditable(false);
        verse = new JTextField(20);
        verse.setText("                                 Verse");
        verse.setEditable(false);
        guessButton = new JButton("Guess");
        clearButton = new JButton("Clear");
        skipButton = new JButton("Skip");
        playButton = new JButton("Play");
        guess = 0;
        count = 0;
        add(textField);
        add(guessButton);
        add(clearButton);
        add(playButton);
        add(instruments);
        add(skipButton);
        add(coverSong);
        add(artistBirth);
        add(verse);
        guessButton.addActionListener(this);
        skipButton.addActionListener(this);
        clearButton.addActionListener(this);
        playButton.addActionListener(this);
        current = instruments;
        song1 = new ArrayList<>();
        song1.add("Test.wav");
        song1.add("Test (3).wav");
        song1.add("Test (2).wav");
        songName = "n in paris";
        musicFiles = song1;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Comic Sans", Font.BOLD, 12));
        g.setColor(Color.WHITE);
        g.drawImage(background, 0, 0, null);
        g.drawString("Enter your guess", 200, 385);
        g.drawString("Guesses: " + guess, 20, 50);
        textField.setLocation(140, 400);
        instruments.setLocation(140, 50);
        artistBirth.setLocation(140, 275);
        coverSong.setLocation(140, 125);
        verse.setLocation(140, 200);
        guessButton.setLocation(100, 425);
        clearButton.setLocation(180, 425);
        playButton.setLocation(255,425);
        skipButton.setLocation(330,425);
    }
    private void playMusic() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/" + musicFiles.get(count)).getAbsoluteFile());
            songClip = AudioSystem.getClip();
            songClip.open(audioInputStream);
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
                System.out.println("Guessed");
                if (textField.getText().equals(songName)){
                    System.out.println("Correct!");
                    songClip.stop();
                    WinFrame w = new WinFrame();
                    enclosingFrame.setVisible(false);
                }else{
                    guess++;
                    count++;
                    textField.setText("");
                    if (current == instruments){
                        instruments.setBackground(Color.RED);
                        coverSong.setBackground(Color.GREEN);
                        current = coverSong;
                        guess++;
                        songClip.stop();
                    }else if (current == coverSong){
                        coverSong.setBackground(Color.RED);
                        verse.setBackground(Color.GREEN);
                        current = verse;
                        guess++;
                        songClip.stop();
                    } else if (current == verse){
                        verse.setBackground(Color.RED);
                        artistBirth.setBackground(Color.GREEN);
                        current = artistBirth;
                        guess++;
                        songClip.stop();
                    }
                }
            }else if (button == playButton) {
                System.out.println("Music Played");
                if (current == instruments){
                    playMusic();
                } else if (current == coverSong){
                    playMusic();
                } else if (current == verse){
                    playMusic();
                }
            }else if (button == skipButton){
                System.out.println("Section Skipped");
                if (current == instruments){
                    instruments.setBackground(Color.RED);
                    coverSong.setBackground(Color.GREEN);
                    current = coverSong;
                    guess++;
                    songClip.stop();
                }else if (current == coverSong){
                    coverSong.setBackground(Color.RED);
                    verse.setBackground(Color.GREEN);
                    current = verse;
                    guess++;
                    songClip.stop();
                } else if (current == verse){
                    verse.setBackground(Color.RED);
                    artistBirth.setBackground(Color.GREEN);
                    current = artistBirth;
                    guess++;
                    songClip.stop();
                }
            } else{
                textField.setText("");
            }
        }
    }
}
