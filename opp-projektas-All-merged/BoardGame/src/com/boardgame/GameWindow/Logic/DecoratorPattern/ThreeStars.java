package com.boardgame.GameWindow.Logic.DecoratorPattern;
public class ThreeStars extends PlayerDecorate {
    
    public ThreeStars(Player palyer) {
        super(palyer);
    }
    
    public String decorate() {
        return super.decorate()+ decorateWithRedStar();
    }

    private String decorateWithRedStar() {
        return " with RedStar";
    }
    
}
