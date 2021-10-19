package com.boardgame.GameWindow.Logic.AbstractFactory;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.boardgame.GameWindow.Logic.PlayerIcon;


public class mainTesting {


    public void tranformation (PlayerIcon player, String type)
    {
        FactoryProvider tanks = new FactoryProvider();
        
        if(type == "redTank")
        {
            Tank tank = (Tank)tanks.getFactory("Tank").create("redTank");
            player.setIcon(tank.getTank());
        }
        else if(type == "blueTank")
        {
            Tank tank = (Tank)tanks.getFactory("Tank").create("blueTank");
            player.setIcon(tank.getTank());
        }
        else if(type == "redPlane")
        {
            Plane plane = (Plane)tanks.getFactory("Plane").create("redPlane");
            player.setIcon(plane.getPlane());
        }
        else if(type == "bluePlane")
        {
            Plane plane = (Plane)tanks.getFactory("Plane").create("bluePlane"); 
            player.setIcon(plane.getPlane());
        }
        else if(type == "redCar")
        {
            Car car = (Car)tanks.getFactory("Car").create("redCar");
            player.setIcon(car.getCar());
        }
        else if(type == "blueCar")
        {
            Car car = (Car)tanks.getFactory("Car").create("blueCar");
            player.setIcon(car.getCar());
        }
        
    }
    

    public static void main(String[] args) {

       /* squere even true ==

        IF()
      /*  Tank blue = (Tank)tanks.getFactory("Tank").create("RedTank");  

        System.out.println(blue.getSpeed());

        Plane red = (Plane)tanks.getFactory("Plane").create("BluePlane");  

        System.out.println(red.getSpeed());

        Car car = (Car)tanks.getFactory("Car").create("RedCar");  

        System.out.println(red.getSpeed());




        JFrame obj = new JFrame();
        JButton button = new JButton();
        JButton button1 = new JButton();
       // button.setIcon(car.getCar());
        button1.setIcon(blue.getTank());
        obj.add(button1);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);*/

	}
    
}
