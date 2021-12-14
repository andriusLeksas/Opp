package com.boardgame.GameWindow.Lab2.Visitor;

public interface DiceInterface {

        //every vehicle goes under full service and the vehicle inspector calculates the total service charge
        int accept(DiceVisitor diceInspector);
}
