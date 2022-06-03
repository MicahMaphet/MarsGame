import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class Screen extends JPanel implements ActionListener, KeyListener {
    private final int DELAY = 25;
    private Timer timer;
    private Littguy littguy;
    private MarsBackground marsbackground;
    private MarsFront marsfront;
    private MarsFront2 marsfront2;
    private MarsFront3 marsfront3;
    private RedMartian redmartian;
    private BlueMartian bluemartian;
    private GameOver gameover;
    public boolean xd; //0 left 1 right
    private long starTime =  java.lang.System.currentTimeMillis ();
    public int Screensize = 500;
    private ArrayList<Obstacle> obstacles;

    public Screen() {
      setPreferredSize(new Dimension(1195, 896));
      setBackground(new Color(232, 232, 232));
      littguy = new Littguy();
      obstacles = drawObstacles();
      marsbackground = new MarsBackground(0, 0);
      marsfront = new MarsFront(0, 0);
      marsfront2 = new MarsFront2(0, 0);
      marsfront3 = new MarsFront3(0, 0);
      redmartian = new RedMartian();
      bluemartian = new BlueMartian();
      gameover = new GameOver();
      timer = new Timer(DELAY, this);
      timer.start();
  }
  @Override
  public void actionPerformed(ActionEvent e) {
      littguy.tick();
      redmartian.tick();
      if (littguy.poos.x > redmartian.pos.x + 3) {
        redmartian.left();
      } else if (littguy.poos.x < redmartian.pos.x - 3) {
        redmartian.right();
      }
      if (littguy.poos.y > redmartian.pos.y + 3) {
        redmartian.down();
      } else if (littguy.poos.y < redmartian.pos.y - 3) {
        redmartian.up();
      }

      if ( java.lang.System.currentTimeMillis() - starTime > 20000){
      bluemartian.tick();
      if (littguy.poos.x > bluemartian.pos.x + 3) {
        bluemartian.left();
      } else if (littguy.poos.x < bluemartian.pos.x - 3) {
        bluemartian.right();
      }
      if (littguy.poos.y > bluemartian.pos.y + 3) {
        bluemartian.down();
      } else if (littguy.poos.y < bluemartian.pos.y - 3) {
        bluemartian.up();
      }
    }
      repaint();
  }
  @Override
  public void paintComponent(Graphics g) {
      super.paintComponent(g);
      for (Obstacle obstacle : obstacles){
        obstacle.draw(g, this);
      }
      marsbackground.draw(g, this);

      if (littguy.poos.x < 1000) {      
      littguy.draw(g, this);
      }
      redmartian.draw(g, this);

      if (System.currentTimeMillis() > 20000) {
      bluemartian.draw(g, this);
      }

      marsfront.draw(g, this);
      marsfront2.draw(g, this);
      marsfront3.draw(g, this);
      
      gameover.draw(g, this);

      Toolkit.getDefaultToolkit().sync();
  }
  

  public ArrayList<Obstacle> drawObstacles() {
    ArrayList<Obstacle> ObstacleList = new ArrayList<>();
      ObstacleList.add(new Obstacle(0, 100));
      ObstacleList.add(new Obstacle(50, 100));
      ObstacleList.add(new Obstacle(100, 100));
      ObstacleList.add(new Obstacle(150, 100));
      ObstacleList.add(new Obstacle(200, 100));
      ObstacleList.add(new Obstacle(250, 100));
      ObstacleList.add(new Obstacle(300, 100));
      // another wall
      ObstacleList.add(new Obstacle(400, 0));
      ObstacleList.add(new Obstacle(400, 50));
      ObstacleList.add(new Obstacle(400, 100));
      ObstacleList.add(new Obstacle(400, 150));
      ObstacleList.add(new Obstacle(400, 200));


      return ObstacleList;
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
      littguy.keyPressed(e);
      
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }
}

