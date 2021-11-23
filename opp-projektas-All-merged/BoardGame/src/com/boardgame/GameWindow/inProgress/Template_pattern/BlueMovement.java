package com.boardgame.GameWindow.inProgress.Template_pattern;

public class BlueMovement extends MovementEvent{
    
    public BlueMovement() {
        setName("blue");
        setTiles(-3);
        System.out.println("Factory_Pattern player moves back 3 tiles");
    }


}



