package com.boardgame.GameWindow.Logic.DecoratorPattern;

public class OneStar extends PlayerDecorate {

    public OneStar(Player palyer) {
        super(palyer);
    }
    
    public String decorate() {
        return super.decorate() + decorateWithBlueStar();
    }

    private String decorateWithBlueStar() {
        return " with BlueStar";
    }
    
}
