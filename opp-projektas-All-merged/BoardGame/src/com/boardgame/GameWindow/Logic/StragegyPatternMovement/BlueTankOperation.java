package com.boardgame.GameWindow.Logic.StragegyPatternMovement;

import com.boardgame.GameWindow.Logic.AbstractFactory.FactoryProvider;
import com.boardgame.GameWindow.Logic.AbstractFactory.Tank;

public class BlueTankOperation implements Strategy {

    FactoryProvider vehicles = new FactoryProvider();
    Tank blue = (Tank)vehicles.getFactory("Tank").create("BlueTank"); 
    @Override
    public int doOperation(int rolled) {
 
        if(rolled - blue.getSpeed() < 0)
        return 0;
        else
        return rolled - blue.getSpeed();
    }
    
}
