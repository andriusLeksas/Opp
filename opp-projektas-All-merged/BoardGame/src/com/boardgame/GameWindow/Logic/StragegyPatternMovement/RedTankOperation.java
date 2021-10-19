package com.boardgame.GameWindow.Logic.StragegyPatternMovement;

import com.boardgame.GameWindow.Logic.AbstractFactory.FactoryProvider;
import com.boardgame.GameWindow.Logic.AbstractFactory.Tank;

public class RedTankOperation implements Strategy {

    @Override
    public int doOperation(int rolled) {

        FactoryProvider vehicles = new FactoryProvider();
        Tank red = (Tank)vehicles.getFactory("Tank").create("RedTank"); 
        if(rolled - red.getSpeed() < 0)
        return 0;
        else
        return rolled - red.getSpeed();
        
    }
    
}