package com.boardgame.GameWindow.inProgress.Template_pattern;
public class BlackMovement extends MovementEvent{
    public BlackMovement() {
        setName("black");
        setTiles(-9);
        System.out.println("Factory_Pattern player moves back 3 tiles");
    }
}