package com.boardgame.GameWindow.inProgress.Template_pattern;

public class MovementEventFactory {
    public MovementEvent makeMovementEvent(String newMovementEvent){
    	MovementEvent event = new MovementEvent() {
		};
		
    	return event.CreateTemplate(newMovementEvent);
    }
}