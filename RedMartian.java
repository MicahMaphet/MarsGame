import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class RedMartian {
    public Point pos;
    private BufferedImage image;

    public RedMartian() {
        loadImage();
        pos = new Point(800, 300);
    }
    private void loadImage() {
        try {
            image = ImageIO.read(new File("images/Red Martian.png")); 
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
        pos.x += 2;
    }
    public void right() {
        pos.x -= 2;
    }
    public void down() {
        pos.y += 2;
    }
    public void up() {
        pos.y -= 2;
    }
}
