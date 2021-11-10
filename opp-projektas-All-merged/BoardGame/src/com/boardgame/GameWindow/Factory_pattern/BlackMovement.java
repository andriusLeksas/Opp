package com.boardgame.GameWindow.Factory_pattern;
public class BlackMovement extends MovementEvent{
    public BlackMovement() {
        setName("black");
        setTiles(-9);
        System.out.println("Factory_Pattern player moves back 9 tiles");
    }
}