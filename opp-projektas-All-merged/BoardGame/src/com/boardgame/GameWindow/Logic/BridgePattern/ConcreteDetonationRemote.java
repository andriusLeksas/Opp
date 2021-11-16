package com.boardgame.GameWindow.Logic.BridgePattern;

public class ConcreteDetonationRemote implements DetonationImplementor {
    @Override
    public void applyDetonation(){
        System.out.println("Applying Remote detonation");
    }
}
