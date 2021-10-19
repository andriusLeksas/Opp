package com.boardgame.GameWindow.Logic.ChainOfResponsibility;

import com.boardgame.GameWindow.Factory_pattern.MovementEvent;
import com.boardgame.GameWindow.Factory_pattern.MovementEventFactory;

public class FactoryCreator extends AbstractCreator{

    @Override
    protected void CreateFactory(String message, String type) {
        if(message=="factory"){
            MovementEventFactory f = new MovementEventFactory();
		    MovementEvent event= f.makeMovementEvent(type);
		    System.out.println("name: "+event.getname()+" tiles :"+event.getTiles());
        }
        else if (message !=null){
            this.nextLogger.CreateFactory(message, type);
        }
    }
}
