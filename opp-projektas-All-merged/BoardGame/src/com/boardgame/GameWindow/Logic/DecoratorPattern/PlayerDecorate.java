package com.boardgame.GameWindow.Logic.DecoratorPattern;
public class PlayerDecorate implements Player{
    
    private Player player;
    
    public PlayerDecorate(Player player) {
        this.player = player;
	}

	// standard constructors
    @Override
    public String decorate() {
        System.out.println("Decorator pattern activated");
        return player.decorate();
    }
}
