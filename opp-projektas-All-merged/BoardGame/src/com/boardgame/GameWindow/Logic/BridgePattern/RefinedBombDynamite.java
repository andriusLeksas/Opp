package com.boardgame.GameWindow.Logic.BridgePattern;

public class RefinedBombDynamite extends AbstractBomb {

    public RefinedBombDynamite(DetonationImplementor d){
        super(d);
    }

    public void applyBombDetonation(){
        System.out.println("Dynamite detonation type applying");
        detonation.applyDetonation();
    }
}
