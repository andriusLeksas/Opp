package com.boardgame.GameWindow.Logic.BuilderPattern;

public class Shop {
    public void Construct(TrapBuilder trapBuilder)
    {
        trapBuilder.BuildMaterial();
        trapBuilder.BuildMovesAffected();
        trapBuilder.BuildChance();
        trapBuilder.BuildPrice();
    }
}
