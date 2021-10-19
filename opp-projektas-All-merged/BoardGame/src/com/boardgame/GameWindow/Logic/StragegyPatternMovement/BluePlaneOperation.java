package com.boardgame.GameWindow.Logic.StragegyPatternMovement;

import com.boardgame.GameWindow.Logic.AbstractFactory.FactoryProvider;
import com.boardgame.GameWindow.Logic.AbstractFactory.Plane;

public class BluePlaneOperation implements Strategy {

    @Override
    public int doOperation(int rolled) {

        FactoryProvider vehicles = new FactoryProvider();
        Plane blue = (Plane)vehicles.getFactory("Plane").create("BluePlane"); 
        return rolled * blue.getSpeed() ;
    }
    
}
