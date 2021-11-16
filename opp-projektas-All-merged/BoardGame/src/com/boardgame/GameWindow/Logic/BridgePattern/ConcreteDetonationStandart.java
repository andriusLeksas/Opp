package com.boardgame.GameWindow.Logic.BridgePattern;

public class ConcreteDetonationStandart implements DetonationImplementor {
    @Override
    public void applyDetonation(){
        System.out.println("Applying Standart detonation");
    }
}
