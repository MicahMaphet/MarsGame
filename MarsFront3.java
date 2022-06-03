import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class MarsFront3 {

    private BufferedImage image;

    public MarsFront3(int x, int y) {
        loadImage();
    }
    private void loadImage() {
        try {
            image = ImageIO.read(new File("images/Wall3.0.png")); 
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }
    public void draw(Graphics g, ImageObserver observer) {
        g.drawImage(
            image, 
            340, 
            525, 
            observer
        );
    }
}

