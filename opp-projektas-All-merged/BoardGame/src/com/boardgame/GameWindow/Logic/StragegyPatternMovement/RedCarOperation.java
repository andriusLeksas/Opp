package com.boardgame.GameWindow.Logic.StragegyPatternMovement;


import com.boardgame.GameWindow.Logic.AbstractFactory.Car;
import com.boardgame.GameWindow.Logic.AbstractFactory.FactoryProvider;

public class RedCarOperation implements Strategy {

    @Override
    public int doOperation(int rolled) {

        FactoryProvider vehicles = new FactoryProvider();
        Car red = (Car)vehicles.getFactory("Car").create("RedCar"); 
        return rolled + red.getSpeed() ;
    }
    
}
