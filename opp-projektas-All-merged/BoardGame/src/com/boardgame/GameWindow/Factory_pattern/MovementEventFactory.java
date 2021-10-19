package com.boardgame.GameWindow.Factory_pattern;

public class MovementEventFactory {
    public MovementEvent makeMovementEvent(String newMovementEvent){
    	MovementEvent event = new MovementEvent() {
		};
		
    	return event.CreateTemplate(newMovementEvent);
    }
}