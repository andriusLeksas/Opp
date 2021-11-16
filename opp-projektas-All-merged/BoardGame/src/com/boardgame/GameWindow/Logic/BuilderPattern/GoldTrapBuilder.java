package com.boardgame.GameWindow.Logic.BuilderPattern;

public class GoldTrapBuilder extends TrapBuilder {

    public GoldTrapBuilder()
    {
        trap = new Trap("GoldTrap");
    }
    @Override
    public void BuildMaterial()
    {
        trap._parts.put("material", "Gold");
    }
    @Override
    public void BuildPrice()
    {
        trap._parts.put("price", "15");
    }
    @Override
    public void BuildMovesAffected()
    {
        trap._parts.put("movesAffected", "3");
    }

    @Override
    public void BuildChance()
    {
        trap._parts.put("chance", "75");
    }
}
