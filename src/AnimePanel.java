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

public class AnimePanel extends JPanel implements ActionListener {

    private JTextField textField;
    private JTextField instruments;
    private JTextField artistBirth;
    private JTextField coverSong;
    private JTextField verse;
    private JTextField current;
    private Clip songClip;
    private boolean playing;

    private ArrayList<String> musicFiles;
    private ArrayList<String> song1;
    private ArrayList<String> song2;
    private ArrayList<String> song3;
    private ArrayList<String> song4;


    private JButton guessButton;
    private JButton playButton;
    private JButton clearButton;
    private JButton skipButton;
    private JTextField birth;
    private int guess;
    private JFrame enclosingFrame;
    private JTextField streams;
    private String songName;
    private BufferedImage background;
    private int count;

    public AnimePanel(JFrame frame) {
        enclosingFrame = frame;
        try {
            background = ImageIO.read(new File("src/animebackground.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        textField = new JTextField(20);
        birth = new JTextField(20);
        streams = new JTextField(20);
        instruments = new JTextField(20);
        instruments.setText("                         Instrumental");
        instruments.setBackground(Color.GREEN);
        instruments.setEditable(false);
        artistBirth = new JTextField(20);
        artistBirth.setText("                              Anime");
        artistBirth.setEditable(false);
        coverSong = new JTextField(20);
        coverSong.setText("                       Number of Streams");
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
        add(birth);
        add(streams);
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
        song2 = new ArrayList<>();
        song3 = new ArrayList<>();
        song4 = new ArrayList<>();
        song1.add("music5instrument.wav");
        song1.add("music5verse.wav");
        song2.add("music6instrument.wav");
        song2.add("music6verse.wav");
        song3.add("music7instrument.wav");
        song3.add("music7verse.wav");
        song4.add("music8instrument.wav");
        song4.add("music8verse.wav");
        int rand = (int) (Math.random() * 4) + 1;
        if (rand == 1) {
            musicFiles = song1;
            songName = "blue bird";
            birth.setText("                     Naruto");
            streams.setText("            9.3 Million Streams");
        } else if (rand == 2) {
            musicFiles = song2;
            songName = "crazy noisy bizarre town";
            birth.setText("               JoJo Bizarre Adventure");
            streams.setText("             26 Million Streams");
        } else if (rand == 3) {
            musicFiles = song3;
            songName = "number 1";
            birth.setText("                Bleach");
            streams.setText("              23 Million Streams");
        } else if (rand == 4) {
            musicFiles = song4;
            songName = "black catcher";
            birth.setText("               Black Clover");
            streams.setText("             10 Million Streams");
        } else {
            System.out.println("error");
        }
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
        streams.setLocation(1000, 1000);
        instruments.setLocation(140, 50);
        artistBirth.setLocation(140, 200);
        birth.setLocation(1000, 1000);
        coverSong.setLocation(140, 275);
        verse.setLocation(140, 125);
        guessButton.setLocation(100, 425);
        clearButton.setLocation(180, 425);
        playButton.setLocation(255, 425);
        skipButton.setLocation(330, 425);
    }

    private void playMusic() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/" + musicFiles.get(count)).getAbsoluteFile());
            songClip = AudioSystem.getClip();
            songClip.open(audioInputStream);
            songClip.start();
            playing = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == guessButton) {
                if (textField.getText().equals(songName)) {
                    songClip.stop();
                    WinFrame w = new WinFrame();
                    enclosingFrame.setVisible(false);
                } else{
                    guess++;
                    count++;
                    textField.setText("");
                    if (current == instruments){
                        instruments.setBackground(Color.RED);
                        verse.setBackground(Color.GREEN);
                        current = verse;
                        guess++;
                        songClip.stop();
                        playing = false;
                    }else if (current == verse){
                        verse.setBackground(Color.RED);
                        artistBirth.setBackground(Color.GREEN);
                        artistBirth.setText(birth.getText());
                        current = artistBirth;
                        guess++;
                        count++;
                        songClip.stop();
                        playing = false;
                    } else if (current == artistBirth){
                        artistBirth.setBackground(Color.RED);
                        coverSong.setBackground(Color.GREEN);
                        coverSong.setText(streams.getText());
                        current = coverSong;
                        guess++;
                        count++;
                        songClip.stop();
                        playing = false;
                    }
                    if (guess == 4){
                        LoseFrame l = new LoseFrame();
                        enclosingFrame.setVisible(false);
                    }
                }
            }else if (button == playButton) {
                if (playing) {
                    songClip.stop();
                    playing = false;
                }
                if (current == instruments){
                    playMusic();
                } else if (current == verse){
                    playMusic();
                }
            }else if (button == skipButton){
                if (current == instruments){
                    instruments.setBackground(Color.RED);
                    verse.setBackground(Color.GREEN);
                    current = verse;
                    guess++;
                    count++;
                    if (playing) {
                        songClip.stop();
                        playing = false;
                    }
                }else if (current == verse){
                    verse.setBackground(Color.RED);
                    artistBirth.setBackground(Color.GREEN);
                    artistBirth.setText(birth.getText());
                    current = artistBirth;
                    guess++;
                    count++;
                    if (playing) {
                        songClip.stop();
                        playing = false;
                    }
                } else if (current == artistBirth){
                    artistBirth.setBackground(Color.RED);
                    artistBirth.setText("                      Artist Birth Place");
                    coverSong.setBackground(Color.GREEN);
                    coverSong.setText(streams.getText());
                    current = coverSong;
                    guess++;
                    count++;
                    if (playing) {
                        songClip.stop();
                        playing = false;
                    }
                }
                else{
                    LoseFrame l = new LoseFrame();
                    enclosingFrame.setVisible(false);
                }
            } else{
                textField.setText("");
            }
        }
    }
}