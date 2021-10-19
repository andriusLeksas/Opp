package com.boardgame.GameWindow.Logic.DecoratorPattern;

public class TwoStars extends PlayerDecorate {
    
    public TwoStars(Player palyer) {
        super(palyer);
    }
    
    public String decorate() {
        return super.decorate() + decorateWithYellowStar();
    }

    private String decorateWithYellowStar() {
        return " with YellowStar";
    }
}
