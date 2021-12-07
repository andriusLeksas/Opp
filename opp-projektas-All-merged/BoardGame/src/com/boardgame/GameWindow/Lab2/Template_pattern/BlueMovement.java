package com.boardgame.GameWindow.Lab2.Template_pattern;

public class BlueMovement extends MovementEvent{
    
    public BlueMovement() {
        setName("blue");
        setTiles(-3);
        System.out.println("Factory_Pattern player moves back 3 tiles");
    }


}



