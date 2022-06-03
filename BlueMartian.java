import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class BlueMartian {
    public Point pos;
    private BufferedImage image;

    public BlueMartian() {

        loadImage();
        pos = new Point(600, 600);        
    }
    private void loadImage() {
        try {
            image = ImageIO.read(new File("images/blue martian.png")); 
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
    public void tick() {      

    }
    public void left() {
        pos.x += 3;
    }
    public void right() {
        pos.x -= 3;
    }
    public void down() {
        pos.y += 3;
    }
    public void up() {
        pos.y -= 3;
    }
}
