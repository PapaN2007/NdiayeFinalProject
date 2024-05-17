import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MusicSelectionPanel extends JPanel implements ActionListener {

    private JButton rapButton;
    private JButton countryButton;
    private JButton animeButton;
    private JButton popularButton;
    private JFrame enclosingFrame;
    private BufferedImage background;

    public MusicSelectionPanel(JFrame frame) {
        enclosingFrame = frame;
        try {
            background = ImageIO.read(new File("src/musicbackground.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        rapButton = new JButton("Rap Music");
        countryButton = new JButton("Country Music");
        animeButton = new JButton("Anime Ost");
        popularButton = new JButton("Popular Music");
        add(rapButton);
        add(countryButton);
        add(animeButton);
        add(popularButton);
        rapButton.addActionListener(this);
        countryButton.addActionListener(this);
        animeButton.addActionListener(this);
        popularButton.addActionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Calibri", Font.BOLD, 16));
        g.setColor(Color.BLACK);
        g.drawImage(background, 0, 0, null);
        g.drawString("Please select which music genre you'd like to play", 80, 225);
        rapButton.setLocation(50, 50);
        countryButton.setLocation(325, 375);
        animeButton.setLocation(325, 50);
        popularButton.setLocation(50, 375);
    }

    // ACTIONLISTENER INTERFACE METHODS
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == rapButton) {
                System.out.println("Rap");
            } else if (button == countryButton){
                System.out.println("Country");
            }else if (button == animeButton){
                System.out.println("Anime");
            }else{
                System.out.println("Popular");
            }
        }
    }
}
