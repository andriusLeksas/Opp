package com.boardgame.GameWindow.Factory_pattern;

public class BlueMovement extends MovementEvent{
    
    public BlueMovement() {
        setName("blue");
        setTiles(-3);
        System.out.println("Factory_Pattern player moves back 3 tiles");
    }


}



