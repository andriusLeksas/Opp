package com.boardgame.GameWindow.Lab2.Template_pattern;

public class MovementEventFactory {
    public MovementEvent makeMovementEvent(String newMovementEvent){
    	MovementEvent event = new MovementEvent() {
		};
		
    	return event.CreateTemplate(newMovementEvent);
    }
}