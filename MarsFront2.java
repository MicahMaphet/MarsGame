import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class MarsFront2 {

    private BufferedImage image;

    public MarsFront2(int x, int y) {
        loadImage();
    }
    private void loadImage() {
        try {
            image = ImageIO.read(new File("images/Wall2.0.png")); 
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }
    public void draw(Graphics g, ImageObserver observer) {
        g.drawImage(
            image, 
            390, 
            0, 
            observer
        );
    }
}

