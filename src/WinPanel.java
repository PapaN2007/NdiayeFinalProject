import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class WinPanel extends JPanel{

    private JTextField textField;
    private BufferedImage background;
    private JFrame enclosingFrame;
    private double stringX;


    public WinPanel(JFrame frame) {
        enclosingFrame = frame;
        stringX = 180;
        try {
            background = ImageIO.read(new File("src/background.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        textField = new JTextField("Congrats You Won!!!!!");
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
        g.drawString("Congrats You Won!!!!", (int) stringX,225);
    }
}


