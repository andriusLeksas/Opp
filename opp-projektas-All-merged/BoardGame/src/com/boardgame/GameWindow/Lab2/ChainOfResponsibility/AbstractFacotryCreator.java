package com.boardgame.GameWindow.Lab2.ChainOfResponsibility;

import com.boardgame.GameWindow.Logic.AbstractFactory.Car;
import com.boardgame.GameWindow.Logic.AbstractFactory.FactoryProvider;
import com.boardgame.GameWindow.Logic.AbstractFactory.Plane;
import com.boardgame.GameWindow.Logic.AbstractFactory.Tank;

public class AbstractFacotryCreator extends AbstractCreator{

    @Override
    protected void CreateFactory(String message, String type) {

        if(message=="abstract"){
            FactoryProvider tanks = new FactoryProvider();
            if(type == "redTank")
        {
            Tank tank = (Tank)tanks.getFactory("Tank").create("redTank");
            System.out.println("Speed of tank: "+tank.getSpeed()+" type: "+type);
        }
        else if(type == "blueTank")
        {
            Tank tank = (Tank)tanks.getFactory("Tank").create("blueTank");
            
            System.out.println("Speed of tank: "+tank.getSpeed()+" type: "+type);
        }
        else if(type == "redPlane")
        {
            Plane plane = (Plane)tanks.getFactory("Plane").create("redPlane");
      
            System.out.println("Speed of plane: "+plane.getSpeed()+" type: "+type);
        }
        else if(type == "bluePlane")
        {
            Plane plane = (Plane)tanks.getFactory("Plane").create("bluePlane"); 
           
            System.out.println("Speed of plane: "+plane.getSpeed()+" type: "+type);
        }
        else if(type == "redCar")
        {
            Car car = (Car)tanks.getFactory("Car").create("redCar");
           
            System.out.println("Speed of car: "+car.getSpeed()+" type: "+type);
        }
        else if(type == "blueCar")
        {
            Car car = (Car)tanks.getFactory("Car").create("blueCar");
           
            System.out.println("Speed of car: "+car.getSpeed()+" type: "+type);
        }
            
        }
    }
        
}
