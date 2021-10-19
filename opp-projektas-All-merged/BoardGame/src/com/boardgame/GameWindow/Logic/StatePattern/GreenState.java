package com.boardgame.GameWindow.Logic.StatePattern;

public class GreenState implements State{
    
    public void doAction(StepsCounter counter) {
        System.out.println("Player is in Green state");
        counter.setState(this);	
     }
  
     public String toString(){
        return "Green";
     }
}
