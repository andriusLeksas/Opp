package com.boardgame.GameWindow.inProgress.StatePattern;

public class YellowState implements State {
    
    public void doAction(StepsCounter counter) {
        System.out.println("Player is in stop state");
        counter.setState(this);	
     }
  
     public String toString(){
        return "Yellow";
     }
}
