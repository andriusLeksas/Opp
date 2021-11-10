package NotYetDone.inProgress.flyWeightPattern;

import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class drawImage implements Shape{

    private BufferedImage img = null;
    private ImageIcon icon = null;
    private int sizeX, sizeY;
 
    public drawImage(String path) throws IOException{
        try {
            this.img = ImageIO.read(this.getClass().getResource(path));
           
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }


    @Override
    public ImageIcon draw() {
        
        ImageIcon wIcon = new ImageIcon(img);
        Image image = wIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(sizeX, sizeY,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        icon = new ImageIcon(newimg);  // transform it back
        return icon;
    }
}
