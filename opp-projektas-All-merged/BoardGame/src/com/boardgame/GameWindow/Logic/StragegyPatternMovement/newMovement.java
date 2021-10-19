package com.boardgame.GameWindow.Logic.StragegyPatternMovement;

public class newMovement {
    
    private Strategy strategy;

    public newMovement(Strategy strategy)
    {
        this.strategy = strategy;
    }

    public newMovement()
    {
    }

    public int executeStrategy(int rolled){
        return strategy.doOperation(rolled);
    }

}
