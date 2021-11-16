package com.boardgame.GameWindow.Logic.AbstractFactory;


import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class RedCar implements Car {

    @Override
    public ImageIcon getCar() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(this.getClass().getResource("../../res/redCar.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ImageIcon wIcon = new ImageIcon(img);
         final Image image = wIcon.getImage(); // transform it 
         final Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
         wIcon = new ImageIcon(newimg);  // transform it back
        // TODO Auto-generated method stub
        return wIcon;
    }

    @Override
    public ImageIcon getCarPlayer(int id) {
        BufferedImage img = null;
        if(id == 0){
            try {
                img = ImageIO.read(this.getClass().getResource("../../res/redCarWhite.png"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }  else{
            try {
                img = ImageIO.read(this.getClass().getResource("../../res/redCarBlack.png"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        ImageIcon wIcon = new ImageIcon(img);
        final Image image = wIcon.getImage(); // transform it
        final Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        wIcon = new ImageIcon(newimg);  // transform it back
        // TODO Auto-generated method stub
        return wIcon;
    }

    @Override
    public int getSpeed() {
        // TODO Auto-generated method stub
        return 1;
    }
    
}
