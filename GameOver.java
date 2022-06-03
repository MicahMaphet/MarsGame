import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class GameOver {
    public Point pos;
    private BufferedImage image;

    public GameOver() {

        loadImage();
        pos = new Point(-1250, 300);
    }
    private void loadImage() {
        try {
            image = ImageIO.read(new File("images/GameOver.png")); 
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }
    public void draw(Graphics g, ImageObserver observer) {

        g.drawImage(
            image, 
            pos.x, 
            pos.y, 
            observer
        );
    }
}

