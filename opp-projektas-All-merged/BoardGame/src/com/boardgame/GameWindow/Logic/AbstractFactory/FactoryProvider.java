package com.boardgame.GameWindow.Logic.AbstractFactory;

public class FactoryProvider {

    public AbstractFactory getFactory(String choice){
        
        if("Tank".equalsIgnoreCase(choice)){
            return new TankFactory();
        }
        else if("Plane".equalsIgnoreCase(choice)){
            return new PlaneFactory();
        }
        else if("Car".equalsIgnoreCase(choice)){
            return new CarFactory();
        }
        
        return null;
    }
    
}
