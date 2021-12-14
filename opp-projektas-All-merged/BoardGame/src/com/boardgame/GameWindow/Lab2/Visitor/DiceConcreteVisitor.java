package com.boardgame.GameWindow.Lab2.Visitor;

public class DiceConcreteVisitor implements DiceVisitor {
    int rollMax;
    public DiceConcreteVisitor(int rollM){
        rollMax = rollM;
    }

    @Override
    public int visit(Die die) {
        int roll = 0;
        if(rollMax == 6){
            roll = rollMax;
        }else{
            roll = 9;
        }
        return roll;
    }
}
