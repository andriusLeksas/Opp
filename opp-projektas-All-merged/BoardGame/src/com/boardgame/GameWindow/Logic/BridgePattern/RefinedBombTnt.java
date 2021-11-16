package com.boardgame.GameWindow.Logic.BridgePattern;

public class RefinedBombTnt extends AbstractBomb {

    public RefinedBombTnt(DetonationImplementor d){
        super(d);
    }

    public void applyBombDetonation(){
        System.out.println("Tnt detonation type applying");
        detonation.applyDetonation();
    }
}
