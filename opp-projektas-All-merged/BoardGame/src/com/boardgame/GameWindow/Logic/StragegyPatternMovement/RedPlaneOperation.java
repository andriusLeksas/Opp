package com.boardgame.GameWindow.Logic.StragegyPatternMovement;


import com.boardgame.GameWindow.Logic.AbstractFactory.FactoryProvider;
import com.boardgame.GameWindow.Logic.AbstractFactory.Plane;

public class RedPlaneOperation implements Strategy {

    @Override
    public int doOperation(int rolled) {

        FactoryProvider vehicles = new FactoryProvider();
        Plane red = (Plane)vehicles.getFactory("Plane").create("RedPlane"); 
        return rolled * red.getSpeed() ;
    }
    
}
