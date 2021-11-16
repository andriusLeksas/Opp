package com.boardgame.GameWindow.Logic.BridgePattern;

public abstract class AbstractBomb {
    protected DetonationImplementor detonation;

    public AbstractBomb(DetonationImplementor d){
        this.detonation = d;
    }

    abstract  public void applyBombDetonation();
}
