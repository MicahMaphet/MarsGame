
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyEvent;

public class Littguy {
    public int LitVolVer; //The class littguy's verticle volocity
    public int LitVolHor; //The class littguy's horizontal volocity
    private BufferedImage image;
    public Point poos;
    
 //   public int LittY = pos.y;
   // public int LittX = pos.x;
    public Littguy() {
        loadImage();
        poos = new Point(0, 0); //width 50, height 51
    }


    private void loadImage() {    
        try {
            image = ImageIO.read(new File("images/littguy.png")); //50 by 50 pixels
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }

    public void draw(Graphics g, ImageObserver observer) {
        g.drawImage(
            image, 
            poos.x, 
            poos.y, 
            observer
        );
    }
 //   public int ctrlP(int ctrlX, int ctrlY ) {
   //     pos.x += ctrlX;
     //   pos.y += ctrlY;

    //}

   public void keyPressed(KeyEvent e) {
       final int KickSpeed = 5;
       int key = e.getKeyCode();
//The Code below is just giving an initial kick of speed
       if (LitVolVer > KickSpeed * -1) {
       if (key == KeyEvent.VK_UP) {
                   LitVolVer = LitVolVer - KickSpeed; 
       }
    }
       if (LitVolHor < KickSpeed) {
       if (key == KeyEvent.VK_RIGHT) {
                   LitVolHor = LitVolHor + KickSpeed;
       }
    }
       if (LitVolVer < KickSpeed) {
       if (key == KeyEvent.VK_DOWN) {
                   LitVolVer = LitVolHor + KickSpeed;
       }
    }
       if (LitVolHor > KickSpeed * -1) {
       if (key == KeyEvent.VK_LEFT) {
                   LitVolHor = LitVolHor - KickSpeed;
       }
    }
//This code is the acceleration/main-movement
       if (key == KeyEvent.VK_UP) {
                   LitVolVer--; 
       } else if  (key == KeyEvent.VK_W) {
                   LitVolVer--; 
       }
       if (key == KeyEvent.VK_RIGHT) {
                   LitVolHor++;
       } else if  (key == KeyEvent.VK_D) {
                   LitVolHor++;
       }
       if (key == KeyEvent.VK_DOWN) {
                   LitVolVer++;
       } else if  (key == KeyEvent.VK_S) {
                   LitVolVer++;
       }
       if (key == KeyEvent.VK_LEFT) {
                   LitVolHor--;
       } else if  (key == KeyEvent.VK_A) {
                   LitVolHor--;
       }
   }
   public int getX() {
   return poos.x;
   }
//the code within tick is constantly being activitated (or should be)
    public void tick() {
 //       LittX = pos.x;
   //     LittY = pos.y;

// this is where Littguy tells java to move, the rest is just setting values
        poos.translate(LitVolHor, LitVolVer);  


        final int LGSpeedLimit = 10; // If you change this value the collision will break, unless you change the collsion a bit
//limit speed
        if (LitVolHor < LGSpeedLimit * -1) {
            LitVolHor = LGSpeedLimit * -1;
        }
        if (LitVolVer < LGSpeedLimit * -1) {
            LitVolVer = LGSpeedLimit * -1;
        }
        if (LitVolHor > LGSpeedLimit) {
            LitVolHor = LGSpeedLimit;
        }
        if (LitVolVer > LGSpeedLimit) {
            LitVolVer = LGSpeedLimit;
        }
//slow down
        if (LitVolHor < 0) {
            LitVolHor = LitVolHor + 1;
        } else if (LitVolHor > 0) {
            LitVolHor = LitVolHor - 1;
        }
        if (LitVolVer < 0) {
            LitVolVer = LitVolVer + 1;
        } else if (LitVolVer > 0) {
            LitVolVer = LitVolVer - 1;
        }
//collision boarder
        if (poos.x < 0) {
            poos.x = 0;
        } else if (poos.x > 1850) {
            poos.x = 1850;
        }
        if (poos.y < 0) {
            poos.y = 0;
        } else if (poos.y > 950) {
            poos.y = 950;
         }
// background collision, yes I am individualy setting the values of where Littguy cannot go. It's my first game though
        if (poos.x > 350) { //this is the left
            if (poos.x < 465) {
                if (poos.y < 260)
                  if (LitVolHor > 0) {
                     poos.x = 350;
                } else if (LitVolHor < 0) {//and right collision of the second wall
                    if (poos.x < 465) {
                    poos.x = 465;
                    }
                } 
            }
        }

        if (poos.x > 350) { // to account for overlapping with the block
            if (poos.x < 460) {// this is for going up on the second wall
                if (poos.y < 270) {
                    if (LitVolVer < 0) {
                        if (poos.y > 258) { // it is 10 less pixels because that is Littguys max speed and two more pixels for bufferroom, totalying 12
                    poos.y = 270;
                        }
                    }
                }
            }
        }
 //this is so he can not go through the first wall going up
        if (poos.x >= 0 ) { //from the left side of the wall
            if (poos.x < 308) {//to the right side of the wall
                if (poos.y > 148)
                if (poos.y < 160) {
                    if (LitVolVer < 0) {
                    poos.y = 160;
                }
            }
        }
//this is the collision that stops Littguy from going throught the first wall downards
        if (poos.x >= 0 ) { 
            if (poos.x < 308) {
                if (poos.y > 50) {
                if (poos.y < 65) {
                    if (LitVolVer > 0) {
                    poos.y = 50;
                    }
                }
            }
        }
    }
        if (poos.x > 308) { //this is the collsion for the first wall going left
            if (poos.x < 320) {
                if (poos.y < 150)
                  if (poos.y > 50) {
                  if (LitVolHor < 0) {
                     poos.x = 320; 
                   }
                } 
            }
        }
    }
    if (poos.x > 598) { //this is the collsion for the third wall going left
        if (poos.x < 610) {
            if (poos.y < 720)
              if (poos.y > 500) {
              if (LitVolHor < 0) {
                 poos.x = 610; 
               }
            } 
        }
    }
        if (poos.x > 300) { //this is the collsion for the third wall going right
            if (poos.x < 312) {
                if (poos.y < 720) {
                  if (poos.y > 500) {
             //      if (LitVolHor > 0) {
                     poos.x = 300; 
               //    }
               } 
            }
        }
    }
    if (poos.x > 300) { //this is the collsion for the third wall going up
        if (poos.x < 610) {
            if (poos.y < 720) {
              if (poos.y > 708) {
              if (LitVolVer < 0) {
                 poos.y = 720; 
               }
            }
            } 
        }
    }
    if (poos.x > 300) { //this is the collsion for the third wall going down
        if (poos.x < 605) {
            if (poos.y < 512)
              if (poos.y > 500) {
              if (LitVolVer > 0) {
                 poos.y = 500; 
               }
            } 
        }
    }
}



    public Point getPos() {
        return poos;
    }

 }
//translate