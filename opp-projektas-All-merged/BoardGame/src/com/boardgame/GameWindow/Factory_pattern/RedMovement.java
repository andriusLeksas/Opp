package com.boardgame.GameWindow.Factory_pattern;
public class RedMovement extends MovementEvent {
    public RedMovement() {
        setName("red");
        setTiles(-6);
        System.out.println("Factory_Pattern player moves back 6 tiles");
    }
    
}