package com.boardgame.GameWindow.Logic.BuilderPattern;

public class SilverTrapBuilder extends  TrapBuilder {

    public SilverTrapBuilder()
    {
        trap = new Trap("SilverTrap");
    }
    @Override
    public void BuildMaterial()
    {
        trap._parts.put("material", "Silver");
    }
    @Override
    public void BuildPrice()
    {
        trap._parts.put("price", "10");
    }
    @Override
    public void BuildMovesAffected()
    {
        trap._parts.put("movesAffected", "2");
    }

    @Override
    public void BuildChance()
    {
        trap._parts.put("chance", "50");
    }
}
