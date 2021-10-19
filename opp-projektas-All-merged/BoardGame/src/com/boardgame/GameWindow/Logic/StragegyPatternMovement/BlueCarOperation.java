package com.boardgame.GameWindow.Logic.StragegyPatternMovement;

import com.boardgame.GameWindow.Logic.AbstractFactory.Car;
import com.boardgame.GameWindow.Logic.AbstractFactory.FactoryProvider;

public class BlueCarOperation implements Strategy {

    @Override
    public int doOperation(int rolled) {

        FactoryProvider vehicles = new FactoryProvider();
        Car blue = (Car)vehicles.getFactory("Car").create("BlueCar"); 
        return rolled + blue.getSpeed() ;
    }
    
}
