package com.boardgame.GameWindow.Logic.StatePattern;

public class demo {
    public static void main(String[] args) {

        StepsCounter counter = new StepsCounter(10);
        System.out.println(counter.getState().toString());
  
        
     }
}
