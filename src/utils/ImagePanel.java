package utils;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author maroo
 */
public class ImagePanel extends JPanel{
     BufferedImage image;
    /** Creates a new instance of MonPanel */
    public ImagePanel(BufferedImage image) {
       // super() ;
        this.image = image;
    }
 
         public void paint(Graphics g) {
                int x = (getWidth() - image.getWidth()) / 2;
            int y = (getHeight() - image.getHeight()) / 2;
    g.drawImage(image, x, y, this);
        } 
 


    
}
