package com.boardgame.GameWindow.Lab2.StatePattern;

public class demo {
    public static void main(String[] args) {

        StepsCounter counter = new StepsCounter(26);
        System.out.println(counter.getState().toString());
  
        
     }
}